package com.caiwl.yungo.service;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.entity.Customer;
import com.caiwl.yungo.mapper.CustomerMapper;
import com.caiwl.yungo.util.HashIdUtil;
import com.caiwl.yungo.util.RedisUtil;
import com.caiwl.yungo.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean exists(String phone) {
        return customerMapper.existsWithPhone(phone);
    }

    @Override
    public Customer info(long id) {
        return customerMapper.get(id);
    }

    @Override
    public Body registry(String phone, String smsCode) {
        String redisKey = RedisUtil.KEY_PREFIX_SMS_CODE_VALUE + phone;
        String redisSmsCode = RedisUtil.get(stringRedisTemplate, redisKey);
        if (StringUtil.notEquals(smsCode, redisSmsCode)) {
            return Body.fail("验证码不正确");
        }
        RedisUtil.del(stringRedisTemplate, redisKey);
        Customer customer = new Customer();
        customer.setPhone(phone);
        customerMapper.insertSelective(customer);
        return Body.success();
    }

    @Override
    public Body login(String phone, String smsCode) {
        String redisKey = RedisUtil.KEY_PREFIX_SMS_CODE_VALUE + phone;
        String redisSmsCode = RedisUtil.get(stringRedisTemplate, redisKey);
        if (StringUtil.notEquals(smsCode, redisSmsCode)) {
            return Body.fail("验证码不正确");
        }
        RedisUtil.del(stringRedisTemplate, redisKey);
        Customer customer = customerMapper.getByPhone(phone);
        // APP首次登录即为注册
        if (customer == null) {
            customer = new Customer();
            customer.setPhone(phone);
            customerMapper.insertSelective(customer);
        }
        String hashId = HashIdUtil.encode(customer.getId());
        return Body.success(hashId);
    }
}
