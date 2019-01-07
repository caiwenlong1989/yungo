package com.caiwl.yungo.conf;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.entity.SmsLog;
import com.caiwl.yungo.mapper.SmsLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
@Slf4j
@Deprecated
public class SmsLogAspect {
    @Autowired
    private SmsLogMapper smsLogMapper;

    @Async
    @AfterReturning(value = "within(com.caiwl.yungo.service.SmsLogServiceImpl)", returning = "body")
    public void afterReturning(JoinPoint joinPoint, Body body) {
        Object[] args = joinPoint.getArgs();
        smsLogMapper.insertSelective(SmsLog.builder()
                .type((Integer) args[0])
                .phone((String) args[1])
                .content((String) args[2])
                .response((String) body.getData())
                .respCode(body.getCode())
                .respMsg(body.getMsg())
                .build());
    }
}
