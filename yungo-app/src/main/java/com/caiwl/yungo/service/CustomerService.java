package com.caiwl.yungo.service;

import com.caiwl.yungo.entity.Customer;

public interface CustomerService {
    boolean exists(String phone);
    Customer info(long id);
}
