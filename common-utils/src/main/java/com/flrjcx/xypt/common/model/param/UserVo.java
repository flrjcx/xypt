package com.flrjcx.xypt.common.model.param;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author Flrjcx
 */
@Data
public class UserVo implements Serializable {
    private static final long serialVersionUID = -5818798255750404065L;
    private Long userId;
    private String nickName;
    private String nickPic;
    private String content;
    private String sex;
    private Date birthday;
    private String phone;
    private String email;
    private String account;
    private String password;
    private BigDecimal balance;
    private Integer fansNum;
    private Integer focusNum;
    private String site;
    private String school;
    private Date createTime;
    private Date updateTime;
    private String status;

}
