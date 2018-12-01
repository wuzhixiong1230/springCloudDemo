package com.oristartech.controller;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableMap;
import com.oristartech.feign.ConsumerFeignTest;
import com.oristartech.service.A8userService;
import com.oristartech.util.SpringContextUtils;

@RestController
public class HelloController {
 
	@Autowired
	A8userService a8userService;
	
	@Autowired
	ConsumerFeignTest consumerFeignTest;
	
	@RequestMapping("/hello/{str}")
	public void say(@PathVariable("str")String str){
		System.out.println("sleep 10s "+str);
//		return str;
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		consumerFeignTest.echo(str);
	}
	
	@RequestMapping("/ticket")
	String ticket(String clazz,String method){
		try {
			Class<?> c = Class.forName(clazz);
			Object t = SpringContextUtils.getBean(c);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Autowired
    Environment env;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> testGet(@RequestParam(value = "version", required = false) String version) {
    	System.out.println(version);
        return ImmutableMap.of("test", "success.", "version", StringUtils.defaultIfEmpty(version, ""), "serverPort", env.getProperty("server.port"));
    }


    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> testPost(@RequestParam(value = "version", required = false) String version, @RequestBody String body) {
        return ImmutableMap.of(
                "test", "success.", "version", StringUtils.defaultIfEmpty(version, ""),
                "serverPort", env.getProperty("server.port"), "body", body);
    }
}