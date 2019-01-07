package com.caiwl.yungo.conf;

import com.caiwl.yungo.util.HashIdUtil;
import com.caiwl.yungo.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author caiwl
 * @date 2019/1/7 10:20
 */
@Slf4j
public class CustomerIdInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String Authorization = request.getHeader("Authorization");
        if (StringUtil.isEmpty(Authorization)) {
            log.error("Authorization is null or ''");
            return false;
        }
        String hashId = Authorization.substring(6);
        long customerId = HashIdUtil.decode(hashId);
        log.info("Authorization HashID={}, customerId={}", hashId, customerId);
        request.setAttribute(Constants.ATTR_CUSTOMER_ID, customerId);
        return true;
    }
}
