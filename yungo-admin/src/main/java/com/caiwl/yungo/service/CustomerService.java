package com.caiwl.yungo.service;

import com.caiwl.yungo.bean.Body;

public interface CustomerService {
    Body list(String phone, int pageNum, int pageSize);
}
