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
    /**
     * 获取用户列表
     *
     * @return
     */
    List<Users> getUserList();

    /**
     * 根据用户状态获取列表
     * @param status 用户状态
     * @return Users列表
     */
    List<Users> getUserListByStatus(@Param("status") int status);

    /**
     * 查询用户详情
     *
     * @param userId
     * @return
     */
    Users getUserInfo(@Param("userId") long userId);

    long updateUser(Users user);

    /**
     * 封禁用户
     *
     * @param userId
     * @param banReason
     * @return
     */
    boolean deleteUser(@Param("userId") long userId,@Param("banReason") String banReason);

    List<Users> getUserListByRegisterTime(@Param("begin") String begin, @Param("end") String end);

    /**
     * 根据账号或昵称模糊查询列表
     *
     * @param account 账号或昵称
     * @return 用户列表
     */
    List<Users> findByNickNameOrAccount(String account);

    /**
     * 解除封禁用户
     *
     * @param userId
     */
    void rescindUser(@Param("userId") long userId);
}
