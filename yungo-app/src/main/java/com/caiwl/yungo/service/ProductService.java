package com.caiwl.yungo.service;

import com.caiwl.yungo.bean.Body;

public interface ProductService {
    Body buy(String phone, long productId, int count);
}
