package com.hgw.commandlinerunnerdemo.commandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * created 2018/10/29
 * author  guangwei.huang
 */
@Component
@Order(1)
public class FirstCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("FirstCommandLineRunner init success ");
    }
}
