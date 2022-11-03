package com.flrjcx.xypt.common.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author malaka
 * @Description 邮箱验证
 * @date 2022/10/29 18:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRegisterDto {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 邮箱验证码
     */
    private String code;

}
