package com.caiwl.yungo.conf;

import com.caiwl.yungo.bean.Body;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ServletRequestBindingException.class)
    @ResponseBody
    public Body reqParamError() {
        return Body.fail("请求参数错误");
    }

    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public Body sqlError(Exception e) {
        log.error("SQLException occurred：", e);
        // 数据库错误，需要及时处理，如短信或邮件提醒等
        return Body.fail("服务器忙，请稍后重试");
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Body otherError(Exception e) {
        log.error("Exception occurred：", e);
        return Body.fail("服务器忙，请稍后重试");
    }
}
