package com.oristartech.feign;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("spring-cloud-consumer")
public interface ConsumerFeignTest {

	@LoadBalanced
	@RequestMapping(value = "/echo/{str}")
	void echo(@PathVariable("str")String str);
	
	
}
