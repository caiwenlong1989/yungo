package com.caiwl.yungo.service;

import com.caiwl.yungo.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public boolean exists(String phone) {
        return customerMapper.existsWithPhone(phone);
    }
}
