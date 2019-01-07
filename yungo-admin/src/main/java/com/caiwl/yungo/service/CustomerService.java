package com.caiwl.yungo.service;

import com.caiwl.yungo.bean.Body;

public interface CustomerService {
    Body page(String phone, int pageNum, int pageSize);
}
