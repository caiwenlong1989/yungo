package com.caiwl.yungo.ctrl;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.enums.SmsLogEnum;
import com.caiwl.yungo.service.CustomerService;
import com.caiwl.yungo.service.SmsLogService;
import com.caiwl.yungo.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/v1/pub")
public class PublicController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SmsLogService smsLogService;

    @GetMapping("/smsCode/register")
    public Body registerSmsCode(@RequestParam String phone) {
        if (customerService.exists(phone)) {
            return Body.fail("该手机号码已注册，可以直接登录哦");
        }
        String content = String.format("您的验证码是：%s", StringUtil.randomNum(6));
        Body body = smsLogService.sendSmsCode(SmsLogEnum.Type.REGISTER.getType(), phone, content);
        if (body.getCode() == SmsLogEnum.RespCode.SUBMIT_SUCCESS.getCode()) {
            return Body.success();
        }
        return Body.fail("短信发送失败，请联系客服处理");
    }

}
