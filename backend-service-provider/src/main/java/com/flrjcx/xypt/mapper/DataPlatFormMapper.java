package com.flrjcx.xypt.mapper;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 数据平台
 *
 * @author Flrjcx
 */
public interface DataPlatFormMapper {
    /**
     * 获取平台总交易额度
     *
     * @param beforeTime:开始时间
     * @param afterTime:结束时间
     * @return
     */
    BigDecimal totalTransaction(@Param("beforeTime") Date beforeTime,@Param("afterTime") Date afterTime);

    /**
     * 获取平台总支出额度(提现)
     *
     * @param beforeTime:开始时间
     * @param afterTime:结束时间
     * @return
     */
    BigDecimal totalDeposit(@Param("beforeTime") Date beforeTime,@Param("afterTime") Date afterTime);
}
