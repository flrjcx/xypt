package com.flrjcx.xypt.service;

import com.flrjcx.xypt.common.model.param.common.Users;

import java.util.List;

/**
 * @Author: aftermath
 * @Date: 2022-10-23 19:49:11
 * @Desc:
 */
public interface ManageUserService {
    /**
     * 获取全部用户(分页)
     *
     * @return
     */
    List<Users> getUserList();

    long updateUser(Users user, String token);

    boolean deleteUser(long userId, String token);
}

