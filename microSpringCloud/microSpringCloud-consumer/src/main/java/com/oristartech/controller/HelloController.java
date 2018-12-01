package com.oristartech.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableMap;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.oristartech.config.DemoConfig;
import com.oristartech.feign.ProviderFeignTest;
import com.oristartech.feign.util.JsonUtil;

@RestController
@RefreshScope
public class HelloController {
 
	@Autowired
	ProviderFeignTest providerFeign;
	@Autowired
    DemoConfig config;
	
	@Value("${server.config}")
    private String hello;
	
	@RequestMapping("/config")
	public String config(){
		return hello;
	}
	
	@RequestMapping("/test")
	@HystrixCommand(fallbackMethod = "fallback")
	public String test(){
		return JsonUtil.object2Json(providerFeign.all());
//		providerFeign.ticket("com.oristartech.service.A8userService","getTest");
//		return "Spring Boot hello！";
	}
	
	public String fallback() {
		System.out.println("这是熔断器的降级方法。");
		return "这是熔断器的降级方法。";
    }
	
	@RequestMapping("/hi/{str}")
	@HystrixCommand(fallbackMethod = "fallback")
	public void hi(@PathVariable("str")String str){
		providerFeign.hello(str);
		System.out.println(str);
	}
	
	public void fallback(String str) {
		System.out.println("这是熔断器的降级方法。"+ str);
    }
	
	@RequestMapping("/echo/{str}")
	public void echo(@PathVariable("str")String str){
		System.out.println(str); 
	}
	
	@RequestMapping(value = "/feignGet", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> feignGet(@RequestParam(value = "version", required = false) String version) {
        Map map = providerFeign.testGet(version);
        return ImmutableMap.of("feignGet", "success.", "service-a-result", map);
    }
	
	@RequestMapping(value = "/feignPost", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> feignPost(@RequestParam(value = "version", required = false) String version, @RequestBody String body) {
        Map map = providerFeign.testPost(version, body);
        return ImmutableMap.of("feignPost", "success.", "service-a-result", map);
    }
	
	@RequestMapping(value = "/feignGetNoVersion", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> feignGetNoVersion() {
        Map map = providerFeign.testGet(null);
        return ImmutableMap.of("feignGet", "success.", "service-a-result", map);
    }
	
	@RequestMapping(value = "/feignPostNoVersion", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> feignPostNoVersion(@RequestBody String body) {
        Map map = providerFeign.testPost(null, body);
        return ImmutableMap.of("feignPost", "success.", "service-a-result", map);
	}
}