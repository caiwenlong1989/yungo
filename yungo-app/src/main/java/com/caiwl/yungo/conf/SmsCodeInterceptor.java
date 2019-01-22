package com.caiwl.yungo.conf;

import com.caiwl.yungo.util.DateUtil;
import com.caiwl.yungo.util.RedisUtil;
import com.caiwl.yungo.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 发送短信请求接口拦截器，拦截同一手机号码、同一IP次数限制
 */
@Slf4j
public class SmsCodeInterceptor extends HandlerInterceptorAdapter {
    @Value("${my.sms-code.ip-count-limit}")
    private int smsCodeIpCountLimit;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = getIpAddress(request);
        String key = RedisUtil.KEY_PREFIX_SMS_CODE_IP_COUNT + DateUtil.today() + "_" + ip;
        String ipCountStr = RedisUtil.get(stringRedisTemplate, key);
        if (ipCountStr == null) {
            RedisUtil.set(stringRedisTemplate, key, "1");
            return true;
        }
        int ipCount = Integer.valueOf(ipCountStr);
        if (ipCount >= smsCodeIpCountLimit) {
            log.info("短信请求拦截器，触发同一IP次数限制：{}, {}", ip, smsCodeIpCountLimit);
            return false;
        }
        RedisUtil.set(stringRedisTemplate, key, (ipCount + 1) + "");
        return true;
    }

    private String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtil.ipIsNull(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtil.ipIsNull(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtil.ipIsNull(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtil.ipIsNull(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip != null && ip.length() != 0) {
            ip = ip.split(",")[0];
        }
        if (StringUtil.ipIsNull(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
