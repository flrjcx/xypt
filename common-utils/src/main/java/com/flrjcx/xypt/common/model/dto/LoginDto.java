package com.flrjcx.xypt.common.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录成功返回参数
 * @author malaka
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    private String token;

}
