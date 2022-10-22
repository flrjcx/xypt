package com.flrjcx.xypt.mapper;


import com.flrjcx.xypt.common.model.param.common.ManagerVo;
import com.flrjcx.xypt.common.model.param.common.UserVo;
import com.flrjcx.xypt.common.model.param.register.AddUserParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员登陆模块
 *
 * @author aftermath
 */
public interface ManagerLoginMapper {
    //List<ManagerVo> getManagerList(@Param("pager") AddUserParam param);

    /**
     * 通过账号查询用户
     * @param account 账号
     * @return 用户
     */
    ManagerVo findManagerByAccount(String account);
}
