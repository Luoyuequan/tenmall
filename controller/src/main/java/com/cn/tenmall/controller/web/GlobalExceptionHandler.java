package com.cn.tenmall.controller.web;

import com.cn.tenmall.vo.TenmallResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 自定义全局异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * @ExceptionHandler 是用于描述异常处理方法, 此注解中定义的异常类型为方法可以处理的异常类型 (包含此类型的子类类型)
     */
    @ExceptionHandler(RuntimeException.class)
    public TenmallResult doHandleRuntiomeException(RuntimeException e) {
        e.printStackTrace();
        return new TenmallResult(e);
    }
}
