package com.flrjcx.xypt.mapper;

import com.flrjcx.xypt.common.model.param.register.AddUserParam;
import org.apache.ibatis.annotations.Param;

/**
 * 注册
 *
 * @author Flrjcx
 */
public interface RegisterMapper {
    /**
     * 注册用户
     *
     * @param param
     */
    void addUser(@Param("param") AddUserParam param);
}
