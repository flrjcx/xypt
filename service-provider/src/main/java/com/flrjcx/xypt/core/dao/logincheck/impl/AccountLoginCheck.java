package com.flrjcx.xypt.core.dao.logincheck.impl;

import cn.hutool.crypto.digest.BCrypt;
import com.flrjcx.xypt.common.enums.LoginTypeEnum;
import com.flrjcx.xypt.common.model.param.common.UserVo;
import com.flrjcx.xypt.common.model.param.register.LoginParam;
import com.flrjcx.xypt.common.utils.EncryptUtils;
import com.flrjcx.xypt.core.dao.logincheck.AbstractLoginCheck;
import com.flrjcx.xypt.core.dao.logincheck.LoginVerification;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * 账号登录
 * @author malaka
 */
@Component(LoginTypeEnum.LOGIN_TYPE_ACCOUNT_PASSWORD)
public class AccountLoginCheck  extends AbstractLoginCheck implements LoginVerification {

    @Override
    public UserVo checkLogin(LoginParam loginParam) {
        UserVo userVo = loginMapper.findUserByAccount(loginParam.getUser());
        if (ObjectUtils.isEmpty(userVo)) {
            return userVo;
        }
        String dbPwd = userVo.getPassword();
        if (verificationPassed(loginParam, dbPwd)) {
            return userVo;
        }else {
            return null;
        }
    }

    /**
     * 验证登录是否通过
     * 使用BCrypt加密验证
     * @param loginParam 请求参数
     * @param objs       传入数据库查询出来的用户密码
     * @return 验证是否通过
     */
    @Override
    public boolean verificationPassed(LoginParam loginParam, Object... objs) {
        if (EncryptUtils.check(loginParam.getUserPassword(), objs[0].toString())) {
            return true;
        }else {
            return false;
        }
    }

}

