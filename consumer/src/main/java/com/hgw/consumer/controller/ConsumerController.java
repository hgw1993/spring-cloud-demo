package com.hgw.consumer.controller;

import com.hgw.consumer.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created 2018/10/10
 * author  guangwei.huang
 */
@RestController
public class ConsumerController {
    @Autowired
    private HelloRemote helloRemote;

    @GetMapping(value = "hello")
    public String hello(String name) {
        String s = helloRemote.hello(name);
        return s;
    }
}
