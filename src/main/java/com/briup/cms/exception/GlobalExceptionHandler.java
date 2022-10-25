package com.briup.cms.exception;

import com.briup.cms.utils.Result;
import com.briup.cms.utils.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理
 * @Author lining
 * @Date 2022/10/25
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception ex){
        /*
        *  补充内容
        *
        * */
        return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
    }
}
