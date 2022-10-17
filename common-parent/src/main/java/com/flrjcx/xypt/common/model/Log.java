package com.flrjcx.xypt.common.model;


public class Log {
    private String msg;
    private String code;
    private String success;

    @Override
    public String toString() {
        return "Log{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", success='" + success + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
