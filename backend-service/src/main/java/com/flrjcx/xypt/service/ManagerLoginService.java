package com.flrjcx.xypt.service;

import com.flrjcx.xypt.common.model.dto.LoginDto;
import com.flrjcx.xypt.common.model.param.common.ManagerVo;
import com.flrjcx.xypt.common.model.param.common.UserVo;
import com.flrjcx.xypt.common.model.param.register.LoginParam;

import java.util.List;

/**
 * 管理员登录服务
 *
 * @author Flrjcx
 */
public interface ManagerLoginService {
    LoginDto login(LoginParam loginParam);
}
