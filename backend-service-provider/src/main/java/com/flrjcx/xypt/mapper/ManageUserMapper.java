package com.flrjcx.xypt.mapper;

import com.flrjcx.xypt.common.model.param.common.Users;

import java.util.List;

/**
 * @Author: aftermath
 * @Date: 2022-10-23 19:53:30
 * @Desc:
 */
public interface ManageUserMapper {
    List<Users> getUserList();

    long updateUser(Users user);

    boolean deleteUser(long userId);
}
