package com.flrjcx.xypt.mapper;

import com.flrjcx.xypt.common.annotation.OpenPage;
import com.flrjcx.xypt.common.model.param.common.UserVo;

import java.util.List;

/**
 * 登录
 *
 * @author Flrjcx
 */
public interface LoginMapper {
    /**
     * 获取全部用户
     *
     * @return
     */
    List<UserVo> testUserList();

    /**
     * 通过手机查询用户
     * @param phone 手机号
     * @return 查询到的用户
     */
    UserVo findUserByPhone(String phone);

    /**
     * 通过邮箱查询用户
     * @param email 邮箱
     * @return 用户
     */
    UserVo findUserByEmail(String email);

    /**
     * 通过账号查询用户
     * @param email 账号
     * @return 用户
     */
    UserVo findUserByAccount(String email);
}
