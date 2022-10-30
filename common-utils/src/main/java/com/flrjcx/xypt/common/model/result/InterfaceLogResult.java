package com.flrjcx.xypt.common.model.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 访问日志返回结构体
 *
 * @author Flrjcx
 */
@Data
public class InterfaceLogResult implements Serializable {
    private static final long serialVersionUID = -1186565379246250355L;
    private String ip;
    private String uri;
    private int port;
}
