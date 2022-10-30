package com.flrjcx.xypt.mapper;

import com.flrjcx.xypt.common.model.param.common.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: aftermath
 * @Date: 2022-10-23 19:53:30
 * @Desc:
 */
public interface ManageUserMapper {
    List<Users> getUserList();

    /**
     * 根据用户状态获取列表
     * @param status 用户状态
     * @return Users列表
     */
    List<Users> getUserListByStatus(int status);

    Users getUserInfo(long userId);

    long updateUser(Users user);

    boolean deleteUser(long userId);

    List<Users> getUserListByRegisterTime(@Param("begin") String begin, @Param("end") String end);
}
