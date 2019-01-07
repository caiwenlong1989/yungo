package com.caiwl.yungo.mapper;

import com.caiwl.yungo.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    @Select("select * from t_customer where id = #{id}")
    Customer get(@Param("id") long id);
}
