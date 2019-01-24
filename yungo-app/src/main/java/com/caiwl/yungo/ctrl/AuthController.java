package com.caiwl.yungo.ctrl;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.enums.ApplyAuthEnum;
import com.caiwl.yungo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caiwl
 * @date 2019/1/24 17:45
 */
@RestController
@RequestMapping("/app/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/idCard")
    public Body idCard(Long customerId, String ossKey) {
        return authService.submitAuth(customerId, ApplyAuthEnum.DataType.ID_CARD, ossKey);
    }
    @PostMapping("/mxCarrier")
    public Body mxCarrier(Long customerId, String ossKey) {
        return authService.submitAuth(customerId, ApplyAuthEnum.DataType.MX_CARRIER, ossKey);
    }
    @PostMapping("/info")
    public Body info(Long customerId, String ossKey) {
        return authService.submitAuth(customerId, ApplyAuthEnum.DataType.INFO, ossKey);
    }
}
