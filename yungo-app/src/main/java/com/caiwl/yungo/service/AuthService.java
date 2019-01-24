package com.caiwl.yungo.service;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.enums.ApplyAuthEnum;

/**
 * @author caiwl
 * @date 2019/1/24 19:37
 */
public interface AuthService {
    Body submitAuth(Long customerId, ApplyAuthEnum.DataType dataType, String ossKey);
}
