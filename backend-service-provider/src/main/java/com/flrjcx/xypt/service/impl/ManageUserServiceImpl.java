package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.constants.MessageConstants;
import com.flrjcx.xypt.common.model.param.common.Users;
import com.flrjcx.xypt.common.utils.EmailSendUtils;
import com.flrjcx.xypt.common.utils.KafkaUtils;
import com.flrjcx.xypt.common.utils.TokenService;
import com.flrjcx.xypt.mapper.ManageUserMapper;
import com.flrjcx.xypt.service.ManageUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

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

    @Resource
    private EmailSendUtils emailSendUtils;

    /**
     * 获取全部用户(分页)
     *
     * @return
     */
    @Override
    public List<Users> getUserList() {
        List<Users> userList = manageUserMapper.getUserList();
        for (Users users : userList) {
            users.setUserIdTwo(users.getUserId().toString());
        }
        return userList;
    }

    @Override
    public List<Users> getUserListByStatus(Integer status) {
        if (ObjectUtils.isEmpty(status)){
        return manageUserMapper.getUserListByStatus();
        }
        return manageUserMapper.getUserListByStatusNotNull(status);
    }

    @Override
    public long updateUser(Users user, String token) {
        long rows = manageUserMapper.updateUser(user);
        tokenService.updateCache(token, user);
        return rows;
    }

    /**
     * 封禁用户
     *
     * @param userId
     * @param banReason
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUser(long userId,String banReason) {
        boolean flag = manageUserMapper.deleteUser(userId,banReason);
        if (flag) {
            tokenService.removeUserToken(userId);
            Users users = manageUserMapper.getUserInfo(userId);
            emailSendUtils.sendMail(users.getEmail(), MessageConstants.BAN_EMAIL,MessageConstants.BAN_EMAIL_MESSAGE+banReason);
        }
        return flag;
    }

    @Override
    public Users getUserInfo(long userId) {
        return manageUserMapper.getUserInfo(userId);
    }

    @Override
    public List<Users> getUserListByRegisterTime(String begin, String end) {
        return manageUserMapper.getUserListByRegisterTime(begin, end);
    }

    /**
     * 根据账号或昵称模糊查询列表
     *
     * @param account 账号或昵称
     * @return 用户列表
     */
    @Override
    public List<Users> findByNickNameOrAccount(String account) {
        return manageUserMapper.findByNickNameOrAccount(account);
    }

    /**
     * 解除封禁用户
     *
     * @param userId:用户id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void rescindUser(long userId) {
        manageUserMapper.rescindUser(userId);
        Users users = manageUserMapper.getUserInfo(userId);
        emailSendUtils.sendMail(users.getEmail(), MessageConstants.BAN_RESCIND_USER_EMAIL,MessageConstants.BAN_RESCIND_USER_EMAIL_MESSAGE);
    }


}
