package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.mapper.LoginMapper;
import com.flrjcx.xypt.mapper.PersonalCenterMapper;
import com.flrjcx.xypt.service.PersonalCenterService;
import com.flrjcx.xypt.service.RegisterService;
import org.springframework.stereotype.Service;

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

}
