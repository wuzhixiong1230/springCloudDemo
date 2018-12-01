package com.oristartech;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import com.oristartech.util.SpringContextUtils;

@EnableCircuitBreaker
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ProviderApplication {

//	public static void main(String[] args) {		
//		Scanner scanner = new Scanner(System.in);
//		String port = scanner.nextLine();
//		new SpringApplicationBuilder(ProviderApplication.class).properties("server.port=" + port).run(args);
//	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ac = new SpringApplicationBuilder(ProviderApplication.class).run(args);
		SpringContextUtils.setApplicationContext(ac);
    }
}