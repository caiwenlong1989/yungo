package com.caiwl.yungo.util;

import org.hashids.Hashids;

public class HashIdUtil {
    private static final Hashids HASHIDS = new Hashids("yungo", 16, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    
    public static String encode(long id) {
        return HASHIDS.encode(id);
    }
    
    public static long decode(String hash) {
        long[] nums = HASHIDS.decode(hash);
        // HashID被篡改后会无法解析，数组为{}，所以要判断
        if (nums.length == 0) {
            return 0;
        }
        return Long.valueOf(nums[0]);
    }
    
    public static void main(String[] args) {
        System.out.println(encode(1));
        System.out.println(decode("P43A5KVMAV7WYEDL"));
    }

    public static String encodeHex(String hexa){
        return HASHIDS.encodeHex(hexa);
    }

    public static String decodeHex(String hash){
        if (hash == null) {
            return null;
        }
        return HASHIDS.decodeHex(hash).toUpperCase();
    }
}
