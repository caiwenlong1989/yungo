package com.caiwl.yungo.entity;

import lombok.Builder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_log_buy")
@Builder
public class BuyLog {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;
    private Date createTime;
    private Date updateTime;
    private String phone;
    private Long productId;
    private Integer fromCount;
    private Integer count;
    private Integer toCount;
    private Integer buyStatus;
}
