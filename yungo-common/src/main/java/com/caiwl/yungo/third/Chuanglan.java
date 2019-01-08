package com.caiwl.yungo.third;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.util.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class Chuanglan {
    private static final String URL = "http://smssh1.253.com/msg/send/json";
    private static boolean TEST = true;

    public static Body sendJson(String account, String password, String phone, String content) {
        if (TEST) {
            // 测试
            log.info("创蓝短信 phone={}, content={}", phone, content);
            return Body.builder()
                    .code(0)
                    .msg("")
                    .data("{\"code\":\"0\",\"msgId\":\"18122514344123403\",\"time\":\"20181225143441\",\"errorMsg\":\"\"}")
                    .build();
        }
        JSONObject json = new JSONObject();
        json.put("account", account);
        json.put("password", password);
        json.put("msg", content);
        json.put("phone", phone);
        // 需要状态报告
        json.put("report", true);
        json.put("uid", UUID.randomUUID().toString());
        String body = HttpClientUtil.post(URL, json.toString());
        log.info("创蓝短信 phone={}, content={}, result={}", phone, content, body);
        if (body != null) {
            JSONObject respBody = JSON.parseObject(body);
            int code = respBody.getIntValue("code");
            String msg = respBody.getString("errorMsg");
            return Body.builder().code(code).msg(msg).data(body).build();
        }
        return Body.fail("no response");
    }
}
