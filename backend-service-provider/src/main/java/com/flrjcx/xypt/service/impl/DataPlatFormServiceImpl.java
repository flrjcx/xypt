package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.model.result.data.plat.form.ChartResult;
import com.flrjcx.xypt.common.utils.DateUtils;
import com.flrjcx.xypt.mapper.DataPlatFormMapper;
import com.flrjcx.xypt.service.DataPlatFormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * 数据平台
 *
 * @author Flrjcx
 */
@Service
public class DataPlatFormServiceImpl implements DataPlatFormService {

    @Resource
    private DataPlatFormMapper dataPlatFormMapper;


    /**
     * 获取平台总交易额度
     */
    @Override
    public BigDecimal totalTransaction() {
        return dataPlatFormMapper.totalTransaction();
    }

    /**
     * 获取平台总支出额度(提现)
     *
     * @return
     */
    @Override
    public BigDecimal totalDeposit() {
        return dataPlatFormMapper.totalDeposit();
    }

    /**
     * 获取平台总交易额度(图表)
     *
     * @param beforeTime:开始时间
     * @param afterTime:结束时间
     * @return
     */
    @Override
    public List<ChartResult> totalTransactionChart(Long beforeTime, Long afterTime) {
        return dataPlatFormMapper.totalTransactionChart(DateUtils.dateSubtract(DateUtils.dateToStamp(beforeTime)), DateUtils.dateAdd(DateUtils.dateToStamp(afterTime)));
    }

    /**
     * 获取平台总支出额度(图表)
     *
     * @param beforeTime:开始时间
     * @param afterTime:结束时间
     * @return
     */
    @Override
    public List<ChartResult> totalDepositChart(Long beforeTime, Long afterTime) {
        return dataPlatFormMapper.totalDepositChart(DateUtils.dateSubtract(DateUtils.dateToStamp(beforeTime)), DateUtils.dateAdd(DateUtils.dateToStamp(afterTime)));
    }


}

