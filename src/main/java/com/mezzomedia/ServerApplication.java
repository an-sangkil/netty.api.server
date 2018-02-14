package com.mezzomedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ServerApplication {
	
	@Autowired
	private ApplicationContext context;
	
	public static void main (String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(ServerApplication.class, args);
		MezzoAdServer mezzoAdServer = context.getBean(MezzoAdServer.class);
		mezzoAdServer.start();
	}
	
	
}
