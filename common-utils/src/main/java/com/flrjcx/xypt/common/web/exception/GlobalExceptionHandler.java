package com.flrjcx.xypt.common.web.exception;

import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.exception.ValidationException;
import com.flrjcx.xypt.common.model.result.ResponseData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author malaka
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 用户验证未通过
     * @param e
     * @return
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseData handlerValidationException(ValidationException e) {
        return e.getResponseData();
    }


    /**
     * 未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseData handlerException(Exception e) {
        e.printStackTrace();
        return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_USER_SYSTEM_ERROR);
    }

}
