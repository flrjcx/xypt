package com.flrjcx.xypt.common.model.result.log;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 接口访问日志参数
 *
 * @author Flrjcx
 */
@Data
public class InterfaceLogResult implements Serializable {
    private static final long serialVersionUID = -1186565379246250355L;
    @ApiModelProperty(value = "客户端访问ip", name = "ip")
    private String ip;
    @ApiModelProperty(value = "api访问路径", name = "uri")
    private String uri;
    @ApiModelProperty(value = "访问端口", name = "port")
    private int port;
    @ApiModelProperty(value = "ip归属地", name = "local")
    private String local;
    @ApiModelProperty(value = "访问时间戳", name = "timestamp")
    private Long timestamp;
}
