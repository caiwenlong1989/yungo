package com.caiwl.yungo.rule;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 身份证规则校验，包括：身份证是否过期，年龄限制，区域限制
 * @author caiwl
 * @date 2019/1/16 15:42
 */
public class IdCard {

    private static final DateTimeFormatter YMD = DateTimeFormatter.ofPattern("yyyyMMdd");

    /**
     * 身份证是否过期
     * @param valid 身份证有效期
     * @return
     */
    public static boolean expire(String valid) {
        String end = valid.split("-")[1];
        if (!"长期".equals(end)) {
            LocalDate endDate = LocalDate.parse(end, YMD);
            if (endDate.isBefore(LocalDate.now())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 年龄限制
     * @param birth 出生年月日
     * @return
     */
    private static final int LOWER_LIMIT_AGE = 18;
    private static final int UPPER_LIMIT_AGE = 45;
    public static boolean ageLimit(String birth) {
        LocalDate birthday = LocalDate.parse(birth, YMD);
        int years = birthday.until(LocalDate.now()).getYears();
        if (years < LOWER_LIMIT_AGE || years > UPPER_LIMIT_AGE) {
            return true;
        }
        return false;
    }

    /**
     * 区域限制，目前包括：港澳台，海南，偏远地区
     * @param address 住址
     * @return
     */
    private static final String[] ADDRESS_LIMIT = {"香港", "澳门", "台湾", "台灣", "海南", "新疆", "西藏", "内蒙古", "青海", "宁夏"};
    public static boolean addressLimit(String address) {
        for (int i = 0; i < ADDRESS_LIMIT.length; i++) {
            if (address.contains(ADDRESS_LIMIT[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        String valid = "20050417-20250417";
//        String valid = "20050417-长期";
//        System.out.println(expire(valid));

        System.out.println(ageLimit("20010101"));
    }
}
