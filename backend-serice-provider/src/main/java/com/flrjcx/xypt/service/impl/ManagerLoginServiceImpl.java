package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.model.dto.LoginDto;
import com.flrjcx.xypt.common.model.param.common.ManagerVo;
import com.flrjcx.xypt.common.model.param.common.UserVo;
import com.flrjcx.xypt.common.model.param.register.LoginParam;
import com.flrjcx.xypt.service.ManagerLoginService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wby
 */
@Service
public class ManagerLoginServiceImpl implements ManagerLoginService {
    /**
     * 获取全部用户(分页)
     *
     * @return
     */
    @Override
    public List<ManagerVo> getManagerList() {
        return null;
    }

    @Override
    public LoginDto login(LoginParam loginParam) {

        return null;
    }
}
