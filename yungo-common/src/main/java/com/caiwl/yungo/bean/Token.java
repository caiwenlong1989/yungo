package com.caiwl.yungo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Token实体类
 * @author caiwl
 * @date 2017-12-08 14:21
 *
 */
@Data
@AllArgsConstructor
public class Token {
    /** 访问Token */
    private String accessToken;
    /** 刷新Token，访问Token过期时使用 */
    private String refreshToken;
    /** Token类型 */
    private String type;
}
