package com.flrjcx.xypt.mapper;

import com.flrjcx.xypt.common.model.param.common.UserVo;

import java.util.List;

/**
 *
 * @author Flrjcx
 */
public interface LoginMapper {
    /**
     * 获取全部用户
     *
     * @return
     */
    List<UserVo> testUserList();
}
