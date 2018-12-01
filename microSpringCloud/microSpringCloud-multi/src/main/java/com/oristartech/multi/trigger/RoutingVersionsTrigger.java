package com.oristartech.multi.trigger;

import org.springframework.stereotype.Component;

import com.oristartech.multi.MultiRequest;
import com.oristartech.multi.MultiRequest.MultiBean;

import cn.springcloud.bamboo.BambooRequestContext;
import cn.springcloud.bamboo.ConnectPointContext;
import cn.springcloud.bamboo.LoadBalanceRequestTrigger;

@Component
public class RoutingVersionsTrigger implements LoadBalanceRequestTrigger{

	/**
	 * 启用触发器的开关，true为启用
	 */
	@Override
	public boolean shouldExecute() {
		return true;
	}

	/**
	 * 版本路由触发器，在执行ribbon之前执行这个触发功能。
	 * 根据feign中的服务ID，去multiVersions中寻找替换可用的apiversion
	 * 如果未配置有version则默认对所有版本的服务进行轮询
	 * 有配置则对对应版本的服务进行轮询
	 */
	@Override
	public void before(ConnectPointContext connectPointContext) {
		MultiBean multiBean = MultiRequest.getMultiBean(connectPointContext.getBambooRequest().getServiceId());
		if(multiBean != null){
			BambooRequestContext.currentRequestCentxt().setApiVersion(multiBean.getVersion());
		}
//		System.out.println(connectPointContext.getBambooRequest().getServiceId()+":"+BambooRequestContext.currentRequestCentxt().getApiVersion());
	}

	@Override
	public void after(ConnectPointContext connectPointContext) {
		// TODO Auto-generated method stub
		
	}

}
