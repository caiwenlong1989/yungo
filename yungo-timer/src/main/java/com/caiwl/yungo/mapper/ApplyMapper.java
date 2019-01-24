package com.caiwl.yungo.mapper;

import com.caiwl.yungo.entity.Apply;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author caiwl
 * @date 2019/1/24 20:47
 */
@Repository
public interface ApplyMapper extends Mapper<Apply> {
    @Select("select * from t_apply where apply_status = #{applyStatus}")
    List<Apply> getByStatus(int applyStatus);
}
