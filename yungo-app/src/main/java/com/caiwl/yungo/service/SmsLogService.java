package com.caiwl.yungo.service;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.enums.SmsLogEnum;

public interface SmsLogService {
    Body sendSmsCode(SmsLogEnum.Type type, String phone, String content);
}
