package com.flrjcx.xypt.common.model.result.ip;

import lombok.Data;

import java.io.Serializable;

/**
 * ip详情查询结构体
 *
 * @author Flrjcx
 */
@Data
public class DetailsIpParam implements Serializable {
    private static final long serialVersionUID = -5409755764508331906L;
    private Object ipinfo;
    private Object ipdata;
    private Object adcode;
}
