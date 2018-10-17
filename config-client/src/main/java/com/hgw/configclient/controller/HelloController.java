package com.hgw.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created 2018/10/10
 * author  guangwei.huang
 */
@RestController
@RefreshScope
public class HelloController {

    @Value(value = "${hello.name}")
    private String name;

    @GetMapping(value = "sayHello")
    public String hello(){
        return name;
    }
}
