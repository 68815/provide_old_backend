package com.example.provide_old_backend.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResultVo<Void> handleBusinessException(BusinessException e) {
        return ResultVo.error(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultVo<Void> handleException(Exception e) {
        e.printStackTrace();
        return ResultVo.error("系统异常，请联系管理员");
    }
}
