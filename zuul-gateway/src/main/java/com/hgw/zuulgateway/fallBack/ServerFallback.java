package com.hgw.zuulgateway.fallBack;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * created 2018/11/9
 * author  guangwei.huang
 * <p>
 * 客户端路由请求服务失败时的回退处理
 */
@Component
public class ServerFallback implements FallbackProvider {

    @Override
    public String getRoute() {
        /**
         * 对应服务的serviceId,如果需要所有的调用都支持回退，则return  "*"
         */
//        return "spring-cloud-producer";
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            /**
             * 网关向api服务请求是失败了，但是向网关发起的请求是成功的，
             * 网关和api服务集群对于客户端来说是黑盒子
             * @return
             * @throws IOException
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                Map<String, Object> body = new HashMap<>(2);
                body.put("state", -1);
                body.put("msg", cause.getMessage());
                return new ByteArrayInputStream(JSONObject.toJSONString(body).getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }
}
