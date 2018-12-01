package com.oristartech.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oristartech.feign.util.JsonUtil;
import com.oristartech.feign.vo.A8userVo;
import com.oristartech.mybatis.entity.A8user;
import com.oristartech.mybatis.mapper.A8userMapper;
import com.oristartech.service.A8userService;

@Service
public class A8userServiceImpl implements A8userService {
	
	@Autowired
	A8userMapper a8userMapper;
	
	@Override
	public List<A8userVo> getAll() {
		List<A8user> users = a8userMapper.selectAll();
		List<A8userVo> vos = new ArrayList<A8userVo>();
		for(A8user user : users){
			A8userVo vo = new A8userVo();
			vo.setAccount(user.getAccount());
			vo.setOrderNum(user.getOrderNum());
			vo.setOrgId(user.getOrgId());
			vo.setUserId(user.getUserId());
			vo.setUserName(user.getUserName());
			vo.setUserStatus(user.getUserStatus());
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public List<A8userVo> getTest(A8userVo user, String id, Map<String, A8userVo> map) {
		// TODO Auto-generated method stub
		System.out.println(JsonUtil.object2Json(user));
		System.out.println(id);
		System.out.println(JsonUtil.object2Json(map));
		return null;
	}

}
