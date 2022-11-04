package com.flrjcx.xypt.mapper;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * 我的钱包
 *
 * @author Flrjcx
 */
public interface MyWalletMapper {
    /**
     * 充值
     *
     * @param money
     * @param userId
     */
    void recharge(@Param("money") BigDecimal money,@Param("userId") Long userId);
}
