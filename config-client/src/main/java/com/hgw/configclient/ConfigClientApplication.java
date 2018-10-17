package com.hgw.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ConfigClientApplication.class, args);
		System.out.println(context.getId());
	}
}