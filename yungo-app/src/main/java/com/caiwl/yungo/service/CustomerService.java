package com.caiwl.yungo.service;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.entity.Customer;

public interface CustomerService {
    boolean exists(String phone);

    Customer info(long id);

    Body registry(String phone, String smsCode);

    Body login(String phone, String smsCode);
}
