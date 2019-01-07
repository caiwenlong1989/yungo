package com.caiwl.yungo.service.base;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.entity.SmsLog;
import com.caiwl.yungo.enums.SmsLogEnum;
import com.caiwl.yungo.mapper.SmsLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceImpl implements AsyncService {
    @Autowired
    private SmsLogMapper smsLogMapper;

    @Async
    @Override
    public void saveSmsLog(SmsLogEnum.Type type, String phone, String content, Body body) {
        smsLogMapper.insertSelective(SmsLog.builder()
                .type(type.getType())
                .phone(phone)
                .content(content)
                .response((String) body.getData())
                .respCode(body.getCode())
                .respMsg(body.getMsg())
                .build());
    }
}
