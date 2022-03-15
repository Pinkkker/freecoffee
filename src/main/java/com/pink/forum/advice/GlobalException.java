package com.pink.forum.advice;

import com.pink.forum.message.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalException {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exception(Exception e) {
        log.error("系统错误:[出错原因:{},出错信息:{}]", e.getCause(), e.getMessage());
        if (e instanceof AuthorizationException) {
            return Result.bad("not login");
        }
        return Result.bad(e.getMessage());
    }
}
