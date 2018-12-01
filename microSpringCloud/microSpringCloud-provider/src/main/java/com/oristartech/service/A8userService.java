package com.oristartech.service;

import java.util.List;
import java.util.Map;

import com.oristartech.feign.vo.A8userVo;

public interface A8userService {

	List<A8userVo> getAll();
	
	List<A8userVo> getTest(A8userVo user,String id,Map<String,A8userVo> map);
}
