package com.caiwl.yungo.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author caiwl
 * @date 2019/1/8 10:29
 */
public class DateUtil {
    public static String today() {
        return LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    public static void main(String[] args) {
        System.out.println(today());
    }
}
