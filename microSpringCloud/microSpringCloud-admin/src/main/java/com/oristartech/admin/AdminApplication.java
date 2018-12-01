package com.oristartech.admin;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.config.EnableAdminServer;

/**
 * Hello world!
 *
 */
@Configurable
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
@EnableAutoConfiguration
public class AdminApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(AdminApplication.class, args);
    }
}
