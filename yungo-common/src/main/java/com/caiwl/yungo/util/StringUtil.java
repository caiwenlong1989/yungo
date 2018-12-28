package com.caiwl.yungo.util;

import org.springframework.util.StringUtils;

import java.util.Random;

public class StringUtil extends StringUtils {
    private static Random random = new Random();
    public static String randomNum(int len) {
        return String.valueOf(random.nextDouble()).substring(2, 2 + len);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(randomNum(6));
        }
    }
}
