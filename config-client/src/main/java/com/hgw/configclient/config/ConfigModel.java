package com.hgw.configclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * created 2018/10/10
 * author  guangwei.huang
 */
@RefreshScope  // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class ConfigModel {

    @Value(value = "${hello.name}")
    private String name;

    @Value(value = "${hello.age}")
    private String age;


    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
