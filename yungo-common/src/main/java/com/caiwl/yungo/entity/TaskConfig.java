package com.caiwl.yungo.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_config_task")
@Data
public class TaskConfig {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;
    private Date createTime;
    private Date updateTime;
    private String code;
    private String name;
    private String clazz;
    /** Cron表达式 */
    private String cron;
    /**  */
    private Long fixedRate;
    /**  */
    private Long fixedDelay;
}
