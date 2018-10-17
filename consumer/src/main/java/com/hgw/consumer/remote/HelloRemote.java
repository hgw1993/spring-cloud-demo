package com.hgw.consumer.remote;

import com.hgw.consumer.remote.fallBack.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * created 2018/10/10
 * author  guangwei.huang
 */

/**
 * name:：远程服务名，即spring.application.name配置的名称
 */
@FeignClient(name = "spring-cloud-producer",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    /**
     * 此类中的方法和远程服务中的方法名和参数需保持一致
     * @return
     */
    @RequestMapping(value = "hello")
    public String hello(@RequestParam(value = "name")String name);
}
