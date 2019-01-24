package com.caiwl.yungo.mapper;

import com.caiwl.yungo.entity.Apply;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author caiwl
 * @date 2019/1/24 19:43
 */
@Repository
public interface ApplyMapper extends Mapper<Apply> {
    @Select("select * from t_apply where customer_id = #{customerId}")
    Apply getByCustomerId(@Param("customerId") Long customerId);
}
