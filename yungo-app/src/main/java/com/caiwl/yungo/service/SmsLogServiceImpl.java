package com.caiwl.yungo.service;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.third.Chuanglan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsLogServiceImpl implements SmsLogService {
    @Value("${my.chuanglan.account}")
    private String account;
    @Value("${my.chuanglan.password}")
    private String password;

    @Override
    public Body sendSmsCode(int type, String phone, String content) {
        return Chuanglan.sendJson(account, password, phone, content);
    }
}
