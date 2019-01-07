package com.caiwl.yungo.service.base;

public interface TransactionService {
    boolean buyProduct(String phone, long productId, int from, int count);
}
