package com.caiwl.yungo.service;

import com.caiwl.yungo.entity.BuyLog;
import com.caiwl.yungo.mapper.BuyLogMapper;
import com.caiwl.yungo.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private BuyLogMapper buyLogMapper;

    @Transactional
    @Override
    public boolean buyProduct(String phone, long productId, int from, int count) {
        int rows = productMapper.updateNoBuyCount(productId, from, count);
        if (rows == 1) {
            rows = buyLogMapper.insertSelective(BuyLog.builder()
                    .phone(phone).productId(productId)
                    .fromCount(from).count(count).toCount(from - count)
                    .buyStatus(1)
                    .build());
        }
        // 此处抛出运行时异常，仅为测试事务使用
        // 正式使用时，应该在更新之前判断count是否为0
        if (count == 0) throw new ArithmeticException("数量0的抢购订单无效");
        return rows == 1;
    }
}
