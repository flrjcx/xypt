package com.flrjcx.xypt.service;

import java.math.BigDecimal;

/**
 * 我的钱包
 *
 * @author Flrjcx
 */
public interface MyWalletService {
    /**
     * 充值
     *
     * @param money
     * @param userId
     */
    void recharge(BigDecimal money,Long userId);
}
