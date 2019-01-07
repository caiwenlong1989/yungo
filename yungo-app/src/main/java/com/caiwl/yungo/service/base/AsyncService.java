package com.caiwl.yungo.service.base;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.enums.SmsLogEnum;

public interface AsyncService {
    void saveSmsLog(SmsLogEnum.Type type, String phone, String content, Body body);
}
