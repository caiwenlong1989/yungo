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
@Table(name = "t_apply")
@Data
public class Apply {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;
    private Date createTime;
    private Date updateTime;
    /** 唯一索引 */
    private Long customerId;
    private String phone;
    private int applyStatus;
    private boolean idCardStatus;
    private boolean mxCarrierStatus;
    private boolean infoStatus;
    private String mxTaskId;
    private Date finishAuthTime;
}
