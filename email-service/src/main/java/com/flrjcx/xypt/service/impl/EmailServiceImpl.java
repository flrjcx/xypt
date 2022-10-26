package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.enums.CacheTokenEnum;
import com.flrjcx.xypt.common.exception.WebServiceEnumException;
import com.flrjcx.xypt.common.model.param.email.EmailSendParam;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.common.utils.EmailSendUtils;
import com.flrjcx.xypt.common.utils.TokenService;
import com.flrjcx.xypt.config.EmailConfig;
import com.flrjcx.xypt.mapper.EmailRegisterMapper;
import com.flrjcx.xypt.service.EmailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

import static com.flrjcx.xypt.common.enums.ResultCodeEnum.*;

/**
 * @author malaka
 * @Description TODO
 * @date 2022/10/26 0:42
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Resource
    private EmailConfig emailConfig;

    @Resource
    private EmailSendUtils emailSendUtils;

    @Resource
    private TokenService tokenService;

    @Resource
    private EmailRegisterMapper emailRegisterMapper;

    @Override
    public ResponseData sendRegister(EmailSendParam param) {
        if (!param.getVisitKey().equals(emailConfig.getVisitKey())) {
            throw WebServiceEnumException.buildResponseData(ERROR_EMAIL_SEND_KEY_WRONG);
        }
        String token = param.getToken();
        String url = buildVerificationUrl(emailConfig.getAddr(), token);
        // 获取用户邮箱
        String address = param.getAddress();
        String name = param.getName();
        emailSendUtils.sendFixedMail(address, url, name);
        System.out.println(address);
        System.out.println(url);
        return ResponseData.buildResponse();
    }

    /**
     * 验证注册邮箱
     *
     * @param token
     * @return
     */
    @Transactional
    @Override
    public ResponseData verificationRegister(String token) {
        Long uid = tokenService.getCache(CacheTokenEnum.CACHE_EMAIL.getKey() + token);
        if (ObjectUtils.isEmpty(uid)) {
            return ResponseData.buildErrorResponse(FAIL);
        }
        emailRegisterMapper.setStatusOk(String.valueOf(uid));
        return ResponseData.buildSuccess();
    }

    /**
     * 验证用url
     * @param address
     * @param token
     * @return
     */
    private String buildVerificationUrl(String address, String token) {
        return address + "/xypt/api/email/verificationRegister?token=" + token;
    }
}
