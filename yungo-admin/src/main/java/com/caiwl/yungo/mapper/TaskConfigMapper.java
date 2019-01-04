package com.caiwl.yungo.mapper;

import com.caiwl.yungo.entity.TaskConfig;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface TaskConfigMapper extends Mapper<TaskConfig> {
    @Select("select * from t_config_task where code = #{code}")
    TaskConfig get(@Param("code") String code);
}
