package com.flrjcx.xypt.mapper;

/**
 * @author malaka
 * @Description TODO
 * @date 2022/10/26 18:08
 */
public interface EmailRegisterMapper {

    /**
     * 验证成功
     * @param uid
     */
    void setStatusOk(String uid);

}
