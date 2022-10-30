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

    List<Users> getUserListByStatus(int status);

    long updateUser(Users user, String token);

    boolean deleteUser(long userId, String token);

    Users getUserInfo(long userId);

    List<Users> getUserListByRegisterTime(String begin, String end);

    /**
     * 根据账号或昵称模糊查询列表
     *
     * @param account 账号或昵称
     * @return 用户列表
     */
    List<Users> findByNickNameOrAccount(String account);
}

