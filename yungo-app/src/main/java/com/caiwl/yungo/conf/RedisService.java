package com.caiwl.yungo.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisService {
    public static final String KEY_PREFIX_SMS_CODE_IP_COUNT = "yungo_sms_code_ip_count_";

    /**
     * 默认有效时间2小时
     */
    private static final long DEFAULT_TIMEOUT = 2 * 60 * 60;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value, DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    /**
     * @param key
     * @param value
     * @param timeout 有效时间（单位：秒）
     */
    public void set(String key, String value, long timeout) {
        if (key == null || value == null) {
            return;
        }
        stringRedisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    public String get(String key) {
        if (hasKey(key)) {
            return stringRedisTemplate.opsForValue().get(key);
        }
        return null;
    }

    public void delete(String key) {
        if (hasKey(key)) {
            stringRedisTemplate.delete(key);
        }
    }

    public boolean hasKey(String key) {
        if (key == null) {
            return false;
        }
        return stringRedisTemplate.hasKey(key);
    }

    public boolean expired(String key) {
        if (hasKey(key)) {
            return stringRedisTemplate.boundValueOps(key).getExpire() <= 0;
        }
        return true;
    }

    public long getExpire(String key) {
        if (hasKey(key)) {
            return stringRedisTemplate.boundValueOps(key).getExpire();
        }
        return 0;
    }
}
