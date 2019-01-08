package com.caiwl.yungo.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexMapper {
    @Select("select msg from t_index")
    String getMsg();
}
