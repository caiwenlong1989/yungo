package com.caiwl.yungo.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_log_sms")
@Data
@Builder
public class SmsLog {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;
    private Date createTime;
    private Date updateTime;
    // 1-register
    private Integer type;
    private String phone;
    private String content;
    private String response;
    private Integer respCode;
    private String respMsg;
}
