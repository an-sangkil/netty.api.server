package com.mezzomedia.server.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * 
 * <pre>
 * Class Name  : SpringConfig.java
 * Description : 
 * Modification Information
 *
 *    수정일　　　 　　  		수정자　　　     			  수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2018. 2. 19.          skan               최초생성
 * </pre>
 *
 * @author skan
 * @since 2018. 2. 19.
 * @version 
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
@Configuration
@ComponentScan(basePackages= {"com.mezzomedia.service"})
public class SpringConfig {
	
	@Configuration
	@Profile("test")
	@PropertySource(value={
			"classpath:application-test.yml"
			})
	public  static class testDataSource {
		
	}
	
	
	@Configuration
	@Profile("local")
	@PropertySource(value={
			"classpath:application-local.yml"
			})
	public  static class localDataSource {
		
	}
	
	@Configuration
	@Profile("dev")
	@PropertySource(value={
			"classpath:application-dev.yml"
			})
	public static class devDataSource {
		
	}
	
	@Configuration
	@Profile("prod")
	@PropertySource(value={
			//"classpath:properties/application-prod.properties"
			"classpath:application-prod.yml"
			})
	public static class prodDataSource {
		
	}

}
