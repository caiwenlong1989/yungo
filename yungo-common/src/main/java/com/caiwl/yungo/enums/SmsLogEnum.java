package com.caiwl.yungo.enums;

public class SmsLogEnum {
    public enum Type {
        /** 注册 */
        REGISTRY(1, "您的验证码是：%s，如非本人操作，请忽略本短信。"),
        /** 登录 */
        LOGIN(2, "您的验证码是：%s，如非本人操作，请忽略本短信。"),
        ;

        private int type;
        private String template;
        Type(int type, String template) {
            this.type = type;
            this.template = template;
        }

        public int getType() {
            return type;
        }

        public String getTemplate() {
            return template;
        }
    }

    public enum RespCode {
        /** 提交成功 */
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
