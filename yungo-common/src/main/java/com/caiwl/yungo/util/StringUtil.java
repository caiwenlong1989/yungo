package com.caiwl.yungo.util;

import org.springframework.util.StringUtils;

import java.util.Random;
import java.util.regex.Pattern;

public class StringUtil extends StringUtils {
    private static final Random random = new Random();
    private static final Pattern PATTERN_MOBILE = Pattern.compile("^1[3456789]\\d{9}$");

    public static String randomNum(int len) {
        return String.valueOf(random.nextDouble()).substring(2, 2 + len);
    }

    public static boolean isPhone(String phone) {
        return PATTERN_MOBILE.matcher(phone).matches();
    }

    public static boolean ipIsNull(String ip) {
        return isEmpty(ip) || "unknown".equalsIgnoreCase(ip);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(randomNum(6));
        }
    }
}
