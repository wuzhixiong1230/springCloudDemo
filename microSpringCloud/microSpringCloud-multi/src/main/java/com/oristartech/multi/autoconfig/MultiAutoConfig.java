package com.oristartech.multi.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.oristartech.multi.MultiRequest;
import com.oristartech.multi.MultiRequest.MultiBean;

@Component
public class MultiAutoConfig implements CommandLineRunner {

	@Autowired
	Environment env;
	
	@Override
	public void run(String... args) throws Exception {
		if(env.getProperty("serviceBamboo.multiVersion") != null){
			String[] versionArrays = env.getProperty("serviceBamboo.multiVersion").split(",");
			for(int i = 0 ; i < versionArrays.length ; i++){
				String[] multis = versionArrays[i].split(":");
				MultiBean bean = new MultiBean();
				bean.setServiceId(multis[0]);
				bean.setVersion(multis[1]);
				MultiRequest.getMultiVersions().put(multis[0], bean);
			}
		}
		System.out.println(env.getProperty("serviceBamboo.multiVersion"));		
	}
}
