package com.flrjcx.xypt.mapper;

import com.flrjcx.xypt.common.model.param.common.TransactionParam;
import org.apache.ibatis.annotations.Param;

/**
 * 通用mapper
 *
 * @author Flrjcx
 */
public interface MoneyDetailMapper {

    /**
     * 用户资金明细,平台总交易额
     *
     * @param transactionParam
     */
    void moneyDetail(@Param("transactionParam") TransactionParam transactionParam);
}
