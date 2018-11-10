package com.hgw.eureka.producer.controller;

import com.hgw.eureka.producer.annotation.EnableAuth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created 2018/10/9
 * author  guangwei.huang
 */
@RestController
public class HelloController {

    @GetMapping(value = "hello")
    @EnableAuth(auth = false)
    public String sayHello(String name){
        return "hello "+name;
    }
}


