package com.caiwl.yungo.service;

import com.caiwl.yungo.bean.Body;

public interface AsyncService {
    void saveSmsLog(int type, String phone, String content, Body body);
}
