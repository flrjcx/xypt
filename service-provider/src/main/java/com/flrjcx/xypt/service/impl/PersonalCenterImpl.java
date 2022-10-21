package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.model.param.personal_center.RealNameParam;
import com.flrjcx.xypt.mapper.PersonalCenterMapper;
import com.flrjcx.xypt.service.PersonalCenterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 个人中心
 *
 * @author Flrjcx
 */
@Service
public class PersonalCenterImpl implements PersonalCenterService {
    @Resource
    private PersonalCenterMapper personalCenterMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void realUser(RealNameParam realNameParam) {
        personalCenterMapper.realUser(realNameParam);
    }

    @Override
    public Integer getUserFansNum(Long userId) {
        return personalCenterMapper.getFansNum(userId);
    }

    @Override
    public Integer RealRegisterUserCount(Long realRegisterUserId) {
        return personalCenterMapper.countByUserId(realRegisterUserId);
    }
}
