package com.caiwl.yungo.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_product")
@Data
public class Product {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;
    private Date createTime;
    private Date updateTime;
    private Integer count;
    private Integer buyCount;
    private Integer noBuyCount;
}
