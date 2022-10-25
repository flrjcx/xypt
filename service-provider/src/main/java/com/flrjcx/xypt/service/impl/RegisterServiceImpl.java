package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.model.param.register.AddUserParam;
import com.flrjcx.xypt.mapper.RegisterMapper;
import com.flrjcx.xypt.service.RegisterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 注册实现类
 *
 * @author Flrjcx
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private RegisterMapper registerMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(AddUserParam param) {
//        param.setUserId(UUID.randomUUID().toString());
        param.setUserId(56182341241241224L);
        registerMapper.addUser(param);
    }
}
