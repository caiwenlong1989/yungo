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
        SmsLog smsLog = new SmsLog();
        smsLog.setType(type.getType());
        smsLog.setPhone(phone);
        smsLog.setContent(content);
        smsLog.setResponse((String) body.getData());
        smsLog.setRespCode(body.getCode());
        smsLog.setRespMsg(body.getMsg());
        smsLogMapper.insertSelective(smsLog);
    }
}
