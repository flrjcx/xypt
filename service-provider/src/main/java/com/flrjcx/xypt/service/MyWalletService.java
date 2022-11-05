package com.flrjcx.xypt.service;

import java.math.BigDecimal;

/**
 * 我的钱包
 *
 * @author Flrjcx
 */
public interface MyWalletService {

    /**
     * 充值/提现
     *
     * @param money:金额
     * @param type:类型
     * @return
     */
    int recharge(BigDecimal money,int type);

    /**
     * 获取用户S币
     *
     * @return
     */
    BigDecimal getBalance();
}
