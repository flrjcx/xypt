package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.model.param.common.UserVo;
import com.flrjcx.xypt.common.utils.TokenService;
import com.flrjcx.xypt.mapper.ManageUserMapper;
import com.flrjcx.xypt.service.ManageUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: aftermath
 * @Date: 2022-10-23 19:52:13
 * @Desc:
 */
@Service
public class ManageUserServiceImpl implements ManageUserService {
    @Resource
    ManageUserMapper manageUserMapper;

    @Resource
    TokenService tokenService;

    /**
     * 获取全部用户(分页)
     *
     * @return
     */
    @Override
    public List<Users> getUserList() {
        return manageUserMapper.getUserList();
    }

    @Override
    public long updateUser(Users user, String token) {
        long rows = manageUserMapper.updateUser(user);
        tokenService.updateCache(token, user);
        return rows;
    }

    @Override
    public boolean deleteUser(long userId, String token) {
        boolean flag = manageUserMapper.deleteUser(userId);
        if (flag) {
            tokenService.removeManagerToken(token);
        }
        return flag;
    }
}
