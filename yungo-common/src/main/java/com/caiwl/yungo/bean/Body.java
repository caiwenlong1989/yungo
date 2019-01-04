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
        System.out.println("Body");
        return Body.builder().code(0).msg("success").build();
    }

    public static Body success(Object data) {
        return Body.builder().code(0).msg("success").data(data).build();
    }

    public static Body fail(String msg) {
        return Body.builder().code(-1).msg(msg).build();
    }
}
