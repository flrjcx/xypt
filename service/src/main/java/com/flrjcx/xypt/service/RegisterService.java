package com.flrjcx.xypt.service;

import com.flrjcx.xypt.common.model.param.register.AddUserParam;

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
    void addUser(AddUserParam param);
}
