package com.caiwl.yungo.mapper;

import com.caiwl.yungo.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ProductMapper extends Mapper<Product> {
    @Select("select * from t_product where id = #{id}")
    Product get(@Param("id") long id);

    @Update("update t_product set" +
            " buy_count = buy_count + #{count}," +
            " no_buy_count = no_buy_count - #{count}" +
            " where id = #{id} and no_buy_count = #{from}")
    int updateNoBuyCount(@Param("id") long id, @Param("from") int from, @Param("count") int count);
}
