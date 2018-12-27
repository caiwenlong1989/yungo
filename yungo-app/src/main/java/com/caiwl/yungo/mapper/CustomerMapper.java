package com.caiwl.yungo.mapper;

import com.caiwl.yungo.entity.Customer;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

@Repository
public interface CustomerMapper extends Mapper<Customer> {

    default boolean existsWithPhone(String phone) {
        Example example = new Example(Customer.class);
        example.createCriteria().andEqualTo("phone", phone);
        int count = selectCountByExample(example);
        if (count > 0) {
            return true;
        }
        return false;
    }
}
