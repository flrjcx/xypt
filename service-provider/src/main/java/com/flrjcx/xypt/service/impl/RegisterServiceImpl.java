package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.model.param.common.UserVo;
import com.flrjcx.xypt.common.model.param.register.AddUserParam;
import com.flrjcx.xypt.mapper.LoginMapper;
import com.flrjcx.xypt.mapper.RegisterMapper;
import com.flrjcx.xypt.service.LoginService;
import com.flrjcx.xypt.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

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
    public void addUser(AddUserParam param) {
//        param.setUserId(UUID.randomUUID().toString());
        param.setUserId(56182341241241224L);
        registerMapper.addUser(param);
    }
}
