package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.model.param.common.UserVo;
import com.flrjcx.xypt.mapper.LoginMapper;
import com.flrjcx.xypt.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 登录实现类
 *
 * @author Flrjcx
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginMapper loginMapper;

    @Override
    public List<UserVo> getUserList() {
        return loginMapper.testUserList();
    }
}
