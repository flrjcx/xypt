package com.flrjcx.xypt.service;

import com.flrjcx.xypt.common.model.dto.LoginDto;
import com.flrjcx.xypt.common.model.param.email.EmailSendParam;
import com.flrjcx.xypt.common.model.param.register.AddUserParam;
import com.flrjcx.xypt.common.model.result.ResponseData;

/**
 * 注册服务
 *
 * @author Flrjcx
 */
public interface RegisterService {
    /**
     * 用户注册
     *
     * @param param
     */
    ResponseData addUser(AddUserParam param);

    /**
     * 发送注册邮件
     * @param param
     * @return
     */
    LoginDto sendMail(EmailSendParam param);
}
