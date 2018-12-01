package com.oristartech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oristartech.feign.vo.A8userVo;
import com.oristartech.service.A8userService;

@RestController
public class A8userController {

	@Autowired
	A8userService a8userService;
	
	@RequestMapping("/all")
	public List<A8userVo> all(){
		System.out.println("getall");
		return a8userService.getAll();
	}
}
