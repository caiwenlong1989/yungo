package com.caiwl.yungo.service;

public interface TransactionService {
    boolean buyProduct(String phone, long productId, int from, int count);
}
