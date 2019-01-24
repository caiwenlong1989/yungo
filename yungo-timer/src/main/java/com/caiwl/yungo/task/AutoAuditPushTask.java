package com.caiwl.yungo.task;

import com.alibaba.fastjson.JSON;
import com.caiwl.yungo.entity.Apply;
import com.caiwl.yungo.enums.ApplyEnum;
import com.caiwl.yungo.mapper.ApplyMapper;
import com.caiwl.yungo.util.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Iterator;
import java.util.List;

/**
 * @author caiwl
 * @date 2019/1/24 20:42
 */
@Slf4j
public class AutoAuditPushTask {
    @Value("${my.auto-audit.url}")
    private String url;
    @Autowired
    private ApplyMapper applyMapper;

    public void work() {
        List<Apply> list;
        Iterator<Apply> it;
        Apply apply;
        String json;
        while (true) {
            list = applyMapper.getByStatus(ApplyEnum.ApplyStatus.WAIT_AUTO_AUDIT.getApplyStatus());
            it = list.iterator();
            while (it.hasNext()) {
                apply = it.next();
                json = JSON.toJSONString(apply);
                // JSON串内容再议
                // 机审服务可以多套多台机器，Nginx负载均衡
                String res = HttpClientUtil.post(url, json);
                log.info("推送机审数据：applyId={}, res={}", apply.getId(), res);
            }
        }
    }
}
