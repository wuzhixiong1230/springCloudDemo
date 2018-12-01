package com.oristartech.feign;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oristartech.feign.vo.A8userVo;

@FeignClient("spring-cloud-provider")
public interface ProviderFeignTest {

	@LoadBalanced
	@RequestMapping(value = "/hello/{str}")
	void hello(@PathVariable("str")String str);
	
	@LoadBalanced
	@RequestMapping("/all")
	List<A8userVo> all();
	
//	票务所有接口
	@LoadBalanced
	@RequestMapping("/ticket")
	String ticket(@RequestParam("clazz") String clazz,String method);
	
	@LoadBalanced
	@RequestMapping(path = "/get", method = RequestMethod.GET)
    Map<String, String> testGet(@RequestParam(value = "version", required = false) String version);

	@LoadBalanced
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    Map<String, String> testPost(@RequestParam(value = "version") String version, @RequestBody String body);
							
//	list map key ftype value List
//	         key stype value ABuserVo
//	         key value value json
//	         
//	     map key ftype value string
//	         key stype value
//	         key value value 123
//	         
//	     map key ftype value string
//	         key stype value
//	         key value value 456
//
//	     map key ftype value map
//	         key stype value int
//	         key ttype value ABuserVo
//	         key value value json
				         
				
//	b(List<A8userVo> ,string,string,map<int,ABuserVo>)
}
