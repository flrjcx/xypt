package com.flrjcx.xypt.common.web.exception;

import com.aliyun.oss.ServiceException;
import com.flrjcx.xypt.common.exception.UserValidationException;
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
    @ExceptionHandler(UserValidationException.class)
    public ResponseData handlerServiceException(UserValidationException e) {
        return e.getResponseData();
    }

}
