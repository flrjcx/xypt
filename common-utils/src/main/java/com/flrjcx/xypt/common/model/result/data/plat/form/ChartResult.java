package com.flrjcx.xypt.common.model.result.data.plat.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 数据平台图表返回
 *
 * @author Flrjcx
 */
@Data
public class ChartResult implements Serializable {
    private static final long serialVersionUID = -7536699299646071889L;
    @ApiModelProperty(value = "总数量", name = "amount")
    private BigDecimal amount;
    @ApiModelProperty(value = "日期", name = "date")
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date date;
}
