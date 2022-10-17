package com.flrjcx.xypt.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户类
 * @author Flrjcx
 */
@Data
public class UserModel implements Serializable {
    private static final long userUID = 2550341374870540106L;
    private int id;
    private String name;
    private String password;
    private String email;
    private String sex;
    private String age;
    private String address;
    private long phone;
}
