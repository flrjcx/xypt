package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.model.dto.VerifyCodeDto;
import com.flrjcx.xypt.common.utils.CaptchaUtil;
import com.flrjcx.xypt.service.VerificationCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 验证码功能实现类
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Resource
    private CaptchaUtil captchaUtil;


    @Override
    public VerifyCodeDto createVerificationCode() {
        try {
            VerifyCodeDto verifyCodeDto = captchaUtil.catchaImgCreator();
            return verifyCodeDto;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
