package com.caiwl.yungo.mapper;

import com.caiwl.yungo.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CustomerMapper extends Mapper<Customer> {
    @Select("<script>" +
            "select * from t_customer" +
            "<if test=\"phone != null\"> where phone = #{phone}</if>" +
            "</script>")
    List<Customer> list(@Param("phone") String phone);
}
