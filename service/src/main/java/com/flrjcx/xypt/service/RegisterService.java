package com.flrjcx.xypt.service;

import com.flrjcx.xypt.common.model.param.common.UserVo;
import com.flrjcx.xypt.common.model.param.register.AddUserParam;

import java.util.List;

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
