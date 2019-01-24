package com.caiwl.yungo.ctrl;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.enums.SmsLogEnum;
import com.caiwl.yungo.service.CustomerService;
import com.caiwl.yungo.service.SmsLogService;
import com.caiwl.yungo.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/v1/pub")
public class PublicController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SmsLogService smsLogService;

    @GetMapping("/smsCode/registry")
    public Body registrySmsCode(@RequestParam String phone) {
        if (customerService.exists(phone)) {
            return Body.fail("该手机号码已注册，可以直接登录哦");
        }
        return smsLogService.sendSmsCode(SmsLogEnum.Type.REGISTRY, phone, StringUtil.randomNum(6));
    }

    @GetMapping("/smsCode/login")
    public Body loginSmsCode(@RequestParam String phone) {
        return smsLogService.sendSmsCode(SmsLogEnum.Type.LOGIN, phone, StringUtil.randomNum(6));
    }

    @PostMapping("/registry")
    public Body registry(@RequestParam String phone, @RequestParam String smsCode) {
        return customerService.registry(phone, smsCode);
    }

    @PostMapping("/login")
    public Body login(@RequestParam String phone, @RequestParam String smsCode) {
        return customerService.login(phone, smsCode);
    }

}
