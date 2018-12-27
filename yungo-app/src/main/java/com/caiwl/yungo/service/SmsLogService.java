package com.caiwl.yungo.service;

import com.caiwl.yungo.bean.Body;

public interface SmsLogService {
    Body sendSmsCode(int type, String phone, String content);
}
