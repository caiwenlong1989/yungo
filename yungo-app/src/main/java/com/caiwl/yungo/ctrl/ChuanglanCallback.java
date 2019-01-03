package com.caiwl.yungo.ctrl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;

/**
 * 创蓝短信状态报告通知（建议非及时性回调，通知和业务处理分离，通知时仅存储参数，避免并发；然后定时处理业务）
 */
@RestController
@RequestMapping("/api/v1/callback/chuanglan")
@Slf4j
public class ChuanglanCallback {
    /**
     * 创蓝主动推送发送短信的状态报告
     * @param receiver 接收验证的用户名（不是账户名），是按照用户要求配置的名称，可以为空
     * @param pswd 接收验证的密码，可以为空
     * @param msgid 消息id
     * @param reportTime 运营商返回的状态更新时间，格式YYMMddHHmm，其中 YY=年份的最后两位（00-99）
     * @param mobile 接收短信的手机号码
     * @param notifyTime 253 平台收到运营商回复状态报告的时间，格式 yyMMddHHmmss
     * @param uid 用户在提交该短信时提交的 uid 参数，未提交则无该参数
     * @param length 下发短信计费条数
     * @param status 状态
     * @param statusDesc 状态说明，内容经过 URLEncode 编码(UTF-8)
     */
    @RequestMapping("/report")
    public void report(String receiver, String pswd, String msgid,
                       String reportTime, String mobile, String notifyTime,
                       String uid, String length, String status, String statusDesc) {
        try {
            log.info("创蓝主动推送发送短信的状态报告 phone={}, status={}, statusDesc",
                    mobile, status, URLDecoder.decode(statusDesc, "UTF-8"));
        } catch (Exception e) {
            log.error("创蓝主动推送发送短信的状态报告 decode status desc error");
        }
    }
}
