package com.caiwl.yungo.conf;

import com.caiwl.yungo.bean.Body;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ServletRequestBindingException.class)
    @ResponseBody
    public Body reqParamError() {
        return Body.fail("请求参数错误");
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Body otherError(Exception e) {
        log.error("Exception occurred：", e);
        return Body.fail("服务器忙，请稍后重试");
    }
}
