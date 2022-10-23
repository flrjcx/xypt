package com.flrjcx.xypt.common.enums;


import com.flrjcx.xypt.common.constants.IResultCode;

/**
 * @author quanchao
 */
public enum ResultCodeEnum implements IResultCode {

    /**
     * 成功消息码
     */
    SUCCESS(999999, "成功"),

    /**
     * 失败消息码
     */
    FAIL(0, "失败"),

    /**
     * 登录消息码
     */
    USER_LOGIN_CODE_TECHNICAL_ERROR(100001, "技术用户不允许登录系统！"),
    USER_LOGIN_CODE_ACCESS_IP_ERROR(100002, "客户端登录IP允许范围内！"),
    USER_LOGIN_CODE_USER_LOCKED_ERROR(100003, "用户已被锁定，请联系管理员！"),
    USER_LOGIN_CODE_USER_INVALID_ERROR(100004, "用户待激活，请联系管理员！"),
    USER_LOGIN_CODE_USER_DELETED_ERROR(100005, "用户已被删除，请联系管理员！"),
    USER_LOGIN_CODE_IS_NOT_PWD_ERROR(100006, "账号不允许密码登录！"),
    USER_LOGIN_CODE_IP_NOT_ACCESS_PWD_ERROR(100007, "登录客户端IP不在允许密码登录IP范围内！"),
    USER_LOGIN_CODE_UN_VALID_FROM_ERROR(100008, "账号还未到开始使用期限！"),
    USER_LOGIN_CODE_INVALID_ERROR(100009, "账号已过有效期！"),
    USER_LOGIN_CODE_PASSWORD_INVALID_ERROR(100010, "账号密码已过期！"),
    USER_NOT_EXSIT_ERROR(100011, "用户不存在"),
    USER_LOGIN_PWD_ERROR_CODE(100012, "账号或登录密码错误!"),
    USER_LOGIN_OTHER_CODE(100013, "用户已在其他客户端登录!"),
    ERROR_CODE_NAME_REQUIRED(100014, "用户名必填"),
    ERROR_CODE_PASSWORD_ERROR(100015, "密码必填"),
    ERROR_CODE_TOKEN_ERROR(100016, "token必填"),
    ERROR_CODE_INTOKEN_ERROR(100017, "token无效"),
    CODE_EXSIT_POLICENO(100018, "警号已经存在！"),
    USER_ID_EXSIT_ERROR(100019, "用户ID不能为空"),
    ERROR_CODE_VERIFICATION_REQUIRED(100020, "验证码必填"),
    ERROR_CODE_VERIFICATION_ERROR_CODE(100021, "验证码错误"),

    /**
     * 接口转发服务编码
     */
    ERROR_CODE_HIK_API_URL_EMPTY(200000, "请求url不能为空！"),
    ERROR_CODE_HIK_API_FORWARD(200001, "接口转发错误！"),

    ERROR_CODE_REAL_NAME_IS_EMPTY(800004, "真实姓名不能为空"),
    ERROR_CODE_REAL_NAME_CONTAINS_ILLEGAL_CHARACTERS(800005, "真实姓名不能包含特殊字符"),
    ERROR_CODE_REAL_NAME_INCONFORMITY(800006,"真实姓名必须是2到10位中文字符"),
    ERROR_CODE_ID_CARD_IS_EMPTY(800007, "身份证号不能为空"),
    ERROR_CODE_ID_CARD_INCONFORMITY(800008, "身份证号不符合"),
    ERROR_CODE_REAL_REGISTERED(800009, "已实名，无需重复");

    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
