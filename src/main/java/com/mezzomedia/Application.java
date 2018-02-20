package com.mezzomedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

/**
 * 
 * <pre>
 * Class Name  : ServerApplication.java
 * Description : AD서버 스타트 파일  SpringBoot configuration  
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
@SpringBootApplication
public class ServerApplication {
	
	@Autowired
	private ApplicationContext context;
	
	public static void main (String[] args) throws Exception {
		
		// SpringBoot run 
		SpringApplication application = new SpringApplication(ServerApplication.class);
		
		
		ConfigurableEnvironment environment = new StandardEnvironment();
		environment.setDefaultProfiles("dev");
		application.setEnvironment(environment);
		//application.printBanner();
		ConfigurableApplicationContext context = application.run(args);
		MezzoAdServer mezzoAdServer = context.getBean(MezzoAdServer.class);
		mezzoAdServer.start();
	}
	
	
}
