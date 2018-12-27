package com.caiwl.yungo.enums;

public class SmsLogEnum {
    public enum Type {
        REGISTER(1),
        ;

        private int type;
        Type(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }

    public enum RespCode {
        SUBMIT_SUCCESS(0),
        ;

        private int code;
        RespCode(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}
