package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.annotation.OpenPage;
import com.flrjcx.xypt.common.model.dto.LoginDto;
import com.flrjcx.xypt.common.model.param.common.UserVo;
import com.flrjcx.xypt.common.model.param.register.LoginParam;
import com.flrjcx.xypt.common.utils.TokenService;
import com.flrjcx.xypt.core.dao.logincheck.AbstractLoginCheck;
import com.flrjcx.xypt.core.factory.LoginCheckFactory;
import com.flrjcx.xypt.mapper.LoginMapper;
import com.flrjcx.xypt.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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

    @Resource
    private LoginCheckFactory loginCheckFactory;

    @Resource
    private TokenService tokenService;

    @Override
    public List<UserVo> getUserList() {
        return loginMapper.testUserList();
    }

    @Override
    public LoginDto login(LoginParam loginParam) {
        AbstractLoginCheck check = loginCheckFactory.getBean(loginParam.getLoginType());
        UserVo userVo = check.check(loginParam);
        if (ObjectUtils.isEmpty(userVo)) {
            return null;
        }
        String userToken = tokenService.createToken(userVo);
        return new LoginDto(userToken);
    }

}
