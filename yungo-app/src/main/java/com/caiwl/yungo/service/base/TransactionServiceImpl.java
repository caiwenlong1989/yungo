package com.caiwl.yungo.service.base;

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

    @Transactional(rollbackFor = ArithmeticException.class)
    @Override
    public boolean buyProduct(String phone, long productId, int from, int count) {
        int rows = productMapper.updateNoBuyCount(productId, from, count);
        if (rows == 1) {
            BuyLog buyLog = new BuyLog();
            buyLog.setPhone(phone);
            buyLog.setProductId(productId);
            buyLog.setFromCount(from);
            buyLog.setCount(count);
            buyLog.setToCount(from - count);
            buyLog.setBuyStatus(1);
            rows = buyLogMapper.insertSelective(buyLog);
        }
        // 此处抛出运行时异常，仅为测试事务使用
        // 正式使用时，应该在更新之前判断count是否为0
        if (count == 0) throw new ArithmeticException("数量0的抢购订单无效");
        return rows == 1;
    }
}
