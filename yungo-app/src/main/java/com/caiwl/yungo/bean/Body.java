package com.caiwl.yungo.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Body {
    private int code;
    private String msg;
    private Object data;

    public static Body success() {
        return Body.builder().code(0).msg("success").build();
    }

    public static Body fail(String msg) {
        return Body.builder().code(-1).msg(msg).build();
    }

    public static Body fail(int code, String msg) {
        return Body.builder().code(code).msg(msg).build();
    }
}
