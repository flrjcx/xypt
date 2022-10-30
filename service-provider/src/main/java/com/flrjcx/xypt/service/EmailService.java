package com.flrjcx.xypt.service;

import com.flrjcx.xypt.common.model.param.email.EmailSendParam;
import com.flrjcx.xypt.common.model.result.ResponseData;

/**
 * @author malaka
 * @Description 邮箱发送
 * @date 2022/10/26 1:09
 */
public interface EmailService {

    /**
     * 发送注册邮箱
     * @param param
     * @return
     */
    ResponseData sendRegister(EmailSendParam param);

    /**
     * 验证注册邮箱
     * @param token
     * @return
     */
    ResponseData verificationRegister(String token);

}
