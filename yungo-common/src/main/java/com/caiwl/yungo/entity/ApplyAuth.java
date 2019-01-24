package com.caiwl.yungo.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author caiwl
 * @date 2019/1/24 14:04
 */
@Table(name = "t_apply_auth")
@Data
public class ApplyAuth {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;
    private Date createTime;
    private Date updateTime;
    /** 复合索引 */
    private Long applyId;
    private int dataType;
    private String ossKey;
}
