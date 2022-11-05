package com.flrjcx.xypt.service;


import java.math.BigDecimal;

/**
 * 数据平台
 *
 * @author Flrjcx
 */
public interface DataPlatFormService {
    /**
     * 获取平台总交易额度
     *
     * @param beforeTime:开始时间
     * @param afterTime:结束时间
     * @return
     */
    BigDecimal totalTransaction(Long beforeTime,Long afterTime);

    /**
     * 获取平台总支出额度(提现)
     *
     * @param beforeTime:开始时间
     * @param afterTime:结束时间
     * @return
     */
    BigDecimal totalDeposit(Long beforeTime,Long afterTime);
}
