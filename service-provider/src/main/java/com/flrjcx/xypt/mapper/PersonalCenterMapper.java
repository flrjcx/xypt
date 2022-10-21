package com.flrjcx.xypt.mapper;

import com.flrjcx.xypt.common.model.param.personal_center.RealNameParam;

/**
 * 个人中心
 *
 * @author Flrjcx
 */
public interface PersonalCenterMapper {
    /**
     * 用户实名注册
     * @param realNameParam 用户实名参数
     */
    void realUser(RealNameParam realNameParam);

    /**
     * 获取用户粉丝数量
     * @param userId 当前用户id
     * @return 粉丝数量
     */
    Integer getFansNum(Long userId);

    /**
     * 根据id查询用户记录数
     * @param realRegisterUserId 实名注册用户id
     * @return 数据库中的用户记录数
     */
    Integer countByUserId(Long realRegisterUserId);
}
