package com.flrjcx.xypt.common.model.param.email;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author malaka
 * @Description 邮箱发送
 * @date 2022/10/26 0:57
 */
@Data
public class EmailSendParam {
    @ApiModelProperty(value = "访问密钥",name = "visitKey")
    private String visitKey;
    @ApiModelProperty(value = "发送地址",name = "address")
    private String address;
    @ApiModelProperty(value = "验证token",name = "token")
    private String token;

    @ApiModelProperty(value = "发送给的用户名",name = "name")
    private String name;

}
