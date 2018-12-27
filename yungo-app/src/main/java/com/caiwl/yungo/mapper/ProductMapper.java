package com.caiwl.yungo.mapper;

import com.caiwl.yungo.entity.Product;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ProductMapper extends Mapper<Product> {
    @Select("select * from t_product where id = #{arg0}")
    Product get(long id);

    @Update("update t_product set" +
            " buy_count = buy_count + #{arg2}," +
            " no_buy_count = no_buy_count - #{arg2}" +
            " where id = #{arg0} and no_buy_count = #{arg1}")
    int updateNoBuyCount(long id, int from, int count);
}
