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

    /**
     * 提现
     *
     * @param money
     * @param userId
     */
    void deposit(@Param("money") BigDecimal money,@Param("userId") Long userId);

    /**
     * 检查当前金额是否小于提现金额
     *
     * @param money
     * @param userId
     * @return
     */
    Boolean checkMoney(@Param("money") BigDecimal money,@Param("userId") Long userId);

    /**
     * 获取用户S币
     *
     * @param userId
     * @return
     */
    BigDecimal getBalance(@Param("userId") Long userId);
}
