package com.caiwl.yungo.service;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.entity.Product;
import com.caiwl.yungo.mapper.ProductMapper;
import com.caiwl.yungo.service.base.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private TransactionService transactionService;

    @Override
    public Body buy(String phone, long productId, int count) {
        Product product = productMapper.get(productId);
        int from = product.getNoBuyCount();
        if (from >= count) {
            if (transactionService.buyProduct(phone, productId, from, count)) {
                log.info("抢购成功，phone={}, productId={}, from={}, count={}, to={}",
                        phone, productId, from, count, from - count);
                return Body.success();
            } else {
                log.info("更新失败，phone={}, productId={}, from={}, count={}",
                        phone, productId, from, count);
                return Body.fail("更新失败");
            }
        }
        log.info("热销产品，库存不足，phone={}, productId={}, from={}, count={}",
                phone, productId, from, count);
        return Body.fail("热销产品，库存不足");
    }

    public static void main(String[] args) {
        long phone = 15000000001L;
        Random random = new Random();
        for (int i = 0; i< 100; i++) {
            System.out.println(phone++ + ",1," + random.nextInt(30));
        }
        // JMeter
        // Test Plan
            // Add -> Threads(Users) -> Thread Group
            // Thread Group 设置线程数
            // Add -> Sampler -> HTTP Request 设置URL，参数${param}
            // Add -> Listener -> View Results Tree
            // Add -> Listener -> Aggregate Graph
            // Add -> Config Element -> CSV Data Set Config 设置变量名
    }
}
