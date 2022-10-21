package com.flrjcx.xypt.service;

import com.flrjcx.xypt.common.model.param.personal_center.RealNameParam;

/**
 * 个人中心
 *
 * @author Flrjcx
 */
public interface PersonalCenterService {

    /**
     * 实名注册接口
     * @param realNameParam 实名注册参数
     */
    void realUser(RealNameParam realNameParam);

    /**
     * 用户粉丝数量接口
     * @param userId 当前用户id
     * @return 当前用户粉丝数量
     */
    Integer getUserFansNum(Long userId);

    /**
     * 根据id获取real_register表的用户记录数
     * @param realRegisterUserId 用户id
     * @return 用户记录数
     */
    Integer RealRegisterUserCount(Long realRegisterUserId);
}
