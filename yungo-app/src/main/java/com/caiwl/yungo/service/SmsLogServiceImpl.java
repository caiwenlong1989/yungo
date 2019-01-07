package com.caiwl.yungo.service;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.enums.SmsLogEnum;
import com.caiwl.yungo.service.base.AsyncService;
import com.caiwl.yungo.third.Chuanglan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsLogServiceImpl implements SmsLogService {
    @Value("${my.chuanglan.account}")
    private String account;
    @Value("${my.chuanglan.password}")
    private String password;

    @Autowired
    private AsyncService asyncService;

    @Override
    public Body sendSmsCode(SmsLogEnum.Type type, String phone, String content) {
        Body body = Chuanglan.sendJson(account, password, phone, content);
        asyncService.saveSmsLog(type, phone, content, body);
        return body;
    }
}
