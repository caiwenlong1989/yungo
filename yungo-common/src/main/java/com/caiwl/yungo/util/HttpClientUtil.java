package com.caiwl.yungo.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

@Slf4j
public class HttpClientUtil {
    private static final CloseableHttpClient HTTP_CLIENT;

    static {
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        // 路由个数根据对接的第三方个数设定
        int max = 20, routes = 2;
        connManager.setDefaultMaxPerRoute(max);
        connManager.setMaxTotal(routes * max);
        HTTP_CLIENT = HttpClients.custom().setConnectionManager(connManager).build();
    }

    public static String post(String url, String json) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        try (CloseableHttpResponse response = HTTP_CLIENT.execute(httpPost)) {
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                return EntityUtils.toString(responseEntity);
            }
            return null;
        } catch (Exception e) {
            log.error("url={}, json={}, error={}", url, json, e);
            return null;
        }
    }
}
