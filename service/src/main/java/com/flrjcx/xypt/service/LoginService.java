package com.flrjcx.xypt.service;

import com.flrjcx.xypt.common.model.param.UserVo;

import java.util.List;

/**
 * 登录服务
 *
 * @author Flrjcx
 */
public interface LoginService {
    /**
     * 获取全部用户
     *
     * @return
     */
    List<UserVo> getUserList();
}
