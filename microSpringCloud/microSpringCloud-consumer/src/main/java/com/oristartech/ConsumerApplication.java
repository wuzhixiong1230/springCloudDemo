package com.oristartech;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.core.env.Environment;

@EnableCircuitBreaker
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ConsumerApplication {

	public static String SERVICE_VERSION;
	
	public static void main(String[] args) {
        Environment env = new SpringApplicationBuilder(ConsumerApplication.class).web(true).run(args).getEnvironment();
        SERVICE_VERSION = env.getProperty("serviceBamboo.multiVersion");
    }
}