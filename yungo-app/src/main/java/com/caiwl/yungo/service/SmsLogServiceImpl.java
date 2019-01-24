package com.caiwl.yungo.service;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.enums.SmsLogEnum;
import com.caiwl.yungo.service.base.AsyncService;
import com.caiwl.yungo.third.Chuanglan;
import com.caiwl.yungo.util.RedisUtil;
import com.caiwl.yungo.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SmsLogServiceImpl implements SmsLogService {
    @Value("${my.chuanglan.account}")
    private String account;
    @Value("${my.chuanglan.password}")
    private String password;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private AsyncService asyncService;

    @Override
    public Body sendSmsCode(SmsLogEnum.Type type, String phone, String smsCode) {
        String redisKey = RedisUtil.KEY_PREFIX_SMS_CODE_VALUE + phone;
        String redisSmsCode = RedisUtil.get(stringRedisTemplate, redisKey);
        if (StringUtil.notEmpty(redisSmsCode)) {
            return Body.fail("验证码已发送，请注意查收");
        }
        String content = String.format(type.getTemplate(), smsCode);
        Body body = Chuanglan.sendJson(account, password, phone, content);
        asyncService.saveSmsLog(type, phone, content, body);
        if (body.getCode() == SmsLogEnum.RespCode.SUBMIT_SUCCESS.getCode()) {
            RedisUtil.set(stringRedisTemplate, redisKey, smsCode);
            return Body.success();
        }
        return Body.fail("短信发送失败，请联系客服处理");
    }
}
