package com.oristartech.multi;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class MultiRequest {

	private static final Map<String, MultiBean> multiVersions = new ConcurrentHashMap<String, MultiBean>();
	
	
	public static Map<String, MultiBean> getMultiVersions() {
		return multiVersions;
	}

	public static MultiBean getMultiBean(String serviceid){
		return multiVersions.get(serviceid);
	}
	

	public static class MultiBean{
		
		private String serviceId;
		private String version;
		
		public String getServiceId() {
			return serviceId;
		}
		public void setServiceId(String serviceId) {
			this.serviceId = serviceId;
		}
		public String getVersion() {
			return version;
		}
		public void setVersion(String version) {
			this.version = version;
		}
	}
	
}
