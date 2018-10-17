package com.hgw.consumer.remote.fallBack;

import com.hgw.consumer.remote.HelloRemote;
import org.springframework.stereotype.Component;

/**
 * created 2018/10/10
 * author  guangwei.huang
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello(String name) {
        return "messge send failed";
    }
}
