package com.hgw.eureka.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created 2018/10/9
 * author  guangwei.huang
 */
@RestController
public class HelloController {

    @GetMapping(value = "hello")
    public String sayHello(String name){
        if(true){
            throw new RuntimeException("run exception");
        }
        return "hello "+name;
    }
}

