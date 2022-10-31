package com.flrjcx.xypt.service;

import com.flrjcx.xypt.common.model.dto.LoginDto;
import com.flrjcx.xypt.common.model.param.common.Users;
import com.flrjcx.xypt.common.model.param.register.LoginParam;

import java.util.List;

/**
 * 登录服务
 *
 * @author Flrjcx
 */
public interface LoginService {

    LoginDto login(LoginParam loginParam);

}
