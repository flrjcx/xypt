package com.flrjcx.xypt.common.model.result;


import com.flrjcx.common.enums.ResultCodeEnum;

import java.io.Serializable;

/**
 * @author yi'xiao'yi
 * @title: ResponseData
 * @description: TODO
 * @date 2021/8/1715:24
 */
public class ResponseData<T> implements Serializable {
    private static final long serialVersionUID = -2276444028766844527L;
    private int code;
    private String message;
    public T data;

    public ResponseData() {
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.message = ResultCodeEnum.SUCCESS.getMessage();
    }

    public ResponseData(Integer code, String message, T data) {
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.message = ResultCodeEnum.SUCCESS.getMessage();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseData buildResponse() {
        ResponseData data = new ResponseData();
        data.setCode(ResultCodeEnum.SUCCESS.getCode());
        data.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        data.setData(null);
        return data;
    }

    public static ResponseData buildResponse(String message) {
        ResponseData data = new ResponseData();
        data.setCode(ResultCodeEnum.SUCCESS.getCode());
        data.setMessage(message);
        data.setData(null);
        return data;
    }


    public static <T> ResponseData<T> buildResponse(String message, T t) {
        ResponseData<T> data = new ResponseData<>();
        data.setCode(ResultCodeEnum.SUCCESS.getCode());
        data.setMessage(message);
        data.setData(t);
        return data;
    }

    public static <T> ResponseData<T> buildResponseToStandar(T t) {
        ResponseData<T> data = new ResponseData<>();
        data.setCode(ResultCodeEnum.SUCCESS.getCode());
        data.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        data.setData(t);
        return data;
    }

    public static <T> ResponseData<T> buildResponse(T t) {
        ResponseData<T> data = new ResponseData<>();
        data.setCode(ResultCodeEnum.SUCCESS.getCode());
        data.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        data.setData(t);
        return data;
    }

    public static ResponseData buildErrorResponse(Integer code, String message) {
        ResponseData data = new ResponseData();
        data.setCode(code);
        data.setMessage(message);
        data.setData(null);
        return data;
    }

    public static ResponseData buildResponse(ResultCodeEnum httpResultCode) {
        ResponseData data = new ResponseData();
        data.setCode(httpResultCode.getCode());
        data.setMessage(httpResultCode.getMessage());
        data.setData(null);
        return data;
    }

    public static ResponseData buildErrorResponse(ResultCodeEnum httpResultCode) {
        ResponseData data = new ResponseData();
        data.setCode(httpResultCode.getCode());
        data.setMessage(httpResultCode.getMessage());
        data.setData(null);
        return data;
    }

    public static <T> ResponseData<T> buildErrorResponse(Integer code, String message, T t) {
        ResponseData<T> data = new ResponseData<>();
        data.setCode(code);
        data.setData(t);
        data.setMessage(message);
        return data;
    }

    public static <T> ResponseData<T> buildErrorResponse(ResultCodeEnum httpResultCode, T t) {
        ResponseData<T> data = new ResponseData<>();
        data.setCode(httpResultCode.getCode());
        data.setMessage(httpResultCode.getMessage());
        data.setData(t);
        return data;
    }

    public static ResponseData buildSuccess() {
        ResponseData data = new ResponseData();
        data.setCode(ResultCodeEnum.SUCCESS.getCode());
        data.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return data;
    }

    public boolean judgeSuccess() {
        return this.code == ResultCodeEnum.SUCCESS.getCode();
    }

    public boolean judgeSuccessAndNotnull() {
        return this.code == ResultCodeEnum.SUCCESS.getCode() && this.data != null;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResponseData)) {
            return false;
        } else {
            ResponseData<?> other = (ResponseData) o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                label49:
                {
                    Object thisMessage = this.getMessage();
                    Object otherMessage = other.getMessage();
                    if (thisMessage == null) {
                        if (otherMessage == null) {
                            break label49;
                        }
                    } else if (thisMessage.equals(otherMessage)) {
                        break label49;
                    }

                    return false;
                }

                Object thisData = this.getData();
                Object otherData = other.getData();
                if (thisData == null) {
                    if (otherData != null) {
                        return false;
                    }
                } else if (!thisData.equals(otherData)) {
                    return false;
                }


                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ResponseData;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 59 + this.getCode();
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object data = this.getData();
        result = result * 59 + (data == null ? 43 : data.hashCode());

        return result;
    }

    public boolean isSuccess() {
        return this.code == ResultCodeEnum.SUCCESS.getCode();
    }

    @Override
    public String toString() {
        return "ResponseData(code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
    }
}
