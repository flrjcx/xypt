package com.flrjcx.xypt.core.dao.logincheck;

import com.flrjcx.xypt.common.model.param.common.UserVo;
import com.flrjcx.xypt.common.model.param.register.LoginParam;
import com.flrjcx.xypt.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 登录检查
 * @author malaka
 */
public abstract class AbstractLoginCheck {

    /**
     * 检查登录
     * @param loginParam 用户请求输入信息
     * @return 查询出来的对象
     */
    public abstract UserVo check(LoginParam loginParam);


}
