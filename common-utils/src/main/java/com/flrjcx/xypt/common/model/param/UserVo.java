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
    private Long user_id;
    private String nick_name;
    private String nick_pic;
    private String content;
    private String sex;
    private Date birthday;
    private String phone;
    private String email;
    private String account;
    private String password;
    private BigDecimal balance;
    private Integer fans_num;
    private Integer focus_num;
    private String site;
    private String school;
    private Date create_time;
    private Date update_time;
    private String status;

}
