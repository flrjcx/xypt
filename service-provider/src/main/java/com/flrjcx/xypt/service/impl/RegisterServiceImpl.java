package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.client.EmailSendClient;
import com.flrjcx.xypt.common.enums.CacheTokenEnum;
import com.flrjcx.xypt.common.model.param.common.Users;
import com.flrjcx.xypt.common.model.param.email.EmailSendParam;
import com.flrjcx.xypt.common.model.param.register.AddUserParam;
import com.flrjcx.xypt.common.utils.EncryptUtils;
import com.flrjcx.xypt.common.utils.SnowflakeIdWorker;
import com.flrjcx.xypt.common.utils.TokenService;
import com.flrjcx.xypt.config.EmailConfig;
import com.flrjcx.xypt.mapper.RegisterMapper;
import com.flrjcx.xypt.service.RegisterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 注册实现类
 *
 * @author Flrjcx
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private RegisterMapper registerMapper;

    @Resource
    private SnowflakeIdWorker snowflakeIdWorker;


    @Resource
    private EmailSendClient emailSendClient;

    @Resource
    private EmailConfig emailConfig;
    @Resource
    private TokenService tokenService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(AddUserParam param) {
        // 注册
        Users users = new Users();
        users.setUserId(snowflakeIdWorker.nextId());
        users.setAccount(param.getAccount());
        users.setNickName(param.getAccount());
        users.setEmail(param.getEmail());
        users.setPassword(EncryptUtils.md5AndBCrypt(param.getPassword()));
        users.setSex(param.getSex());
        registerMapper.addUser(users);
        // 创建验证token
        String token = tokenService.createToken(CacheTokenEnum.CACHE_EMAIL, users.getUserId());
        // 发送邮箱
        EmailSendParam emailSendParam = new EmailSendParam();
        emailSendParam.setAddress(param.getEmail());
        emailSendParam.setName(param.getAccount());
        emailSendParam.setVisitKey(emailConfig.getVisitKey());
        emailSendParam.setToken(token);
        emailSendClient.sendRegister(emailSendParam);
    }
}
