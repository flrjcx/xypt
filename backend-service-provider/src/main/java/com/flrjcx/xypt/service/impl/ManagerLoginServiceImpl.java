package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.model.dto.LoginDto;
import com.flrjcx.xypt.common.model.param.common.ManagerVo;
import com.flrjcx.xypt.common.model.param.common.UserVo;
import com.flrjcx.xypt.common.model.param.register.LoginParam;
import com.flrjcx.xypt.common.utils.TokenService;
import com.flrjcx.xypt.core.dao.logincheck.AccountLoginCheck;
import com.flrjcx.xypt.mapper.ManagerLoginMapper;
import com.flrjcx.xypt.service.ManagerLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wby
 */
@Service
public class ManagerLoginServiceImpl implements ManagerLoginService {
    @Resource
    ManagerLoginMapper managerLoginMapper;

    @Resource
    TokenService tokenService;

    @Resource
    AccountLoginCheck check;
    /**
     * 获取全部用户(分页)
     *
     * @return
     */
    @Override
    public List<UserVo> getUserList() {
        return managerLoginMapper.getUserList();
    }

    @Override
    public LoginDto login(LoginParam loginParam) {
        ManagerVo managerVo = check.checkLogin(loginParam);
        String managerToken = tokenService.createToken(managerVo);
        return new LoginDto(managerToken);
    }
}
