package com.caiwl.yungo.util;

import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisUtil {
    public static final String KEY_PREFIX_SMS_CODE_IP_COUNT = "yungo_sms_code_ip_count_";
    public static final String KEY_PREFIX_SMS_CODE_VALUE = "yungo_sms_code_value_";

    /**
     * 默认有效时间2小时
     */
    private static final long DEFAULT_TIMEOUT = 2 * 60 * 60;

    public static void set(StringRedisTemplate stringRedisTemplate, String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value, DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    /**
     * @param key
     * @param value
     * @param timeout 有效时间（单位：秒）
     */
    public static void set(StringRedisTemplate stringRedisTemplate, String key, String value, long timeout) {
        if (key == null || value == null) {
            return;
        }
        stringRedisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    public static String get(StringRedisTemplate stringRedisTemplate, String key) {
        if (has(stringRedisTemplate, key)) {
            return stringRedisTemplate.opsForValue().get(key);
        }
        return null;
    }

    public static void del(StringRedisTemplate stringRedisTemplate, String key) {
        if (has(stringRedisTemplate, key)) {
            stringRedisTemplate.delete(key);
        }
    }

    public static boolean has(StringRedisTemplate stringRedisTemplate, String key) {
        if (key == null) {
            return false;
        }
        return stringRedisTemplate.hasKey(key);
    }

    public static boolean expired(StringRedisTemplate stringRedisTemplate, String key) {
        if (has(stringRedisTemplate, key)) {
            return stringRedisTemplate.boundValueOps(key).getExpire() <= 0;
        }
        return true;
    }

    public static long getExpire(StringRedisTemplate stringRedisTemplate, String key) {
        if (has(stringRedisTemplate, key)) {
            return stringRedisTemplate.boundValueOps(key).getExpire();
        }
        return 0;
    }
}
