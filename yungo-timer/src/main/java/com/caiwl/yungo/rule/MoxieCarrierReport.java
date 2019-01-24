package com.caiwl.yungo.rule;

/**
 * 魔蝎运营商报告规则校验，包括：是否实名，
 * @author caiwl
 * @date 2019/1/16 16:54
 */
public class MoxieCarrierReport {
    /**
     * 是否实名
     * @param reliability
     * @return
     */
    public static boolean realName(String reliability) {
        if ("实名认证".equals(reliability)) {
            return true;
        }
        return false;
    }

    /**
     * 开户时长，单位：月
     * @param in_time
     * @return
     */
    public static boolean inTime(String in_time) {
        if (Integer.valueOf(in_time) <= 3) {
            return true;
        }
        return false;
    }
}
