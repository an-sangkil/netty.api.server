package com.netty.api.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.core.AerospikeTemplate;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;
import com.netty.api.core.repository.aerospike.AerospikeTestRepository;

/**
 *
 * <pre>
 * Description : Aerospike 환경 설정
 * </pre>
 *
 * @author skan
 * @since 2018. 4. 3.
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableAerospikeRepositories(basePackageClasses = {AerospikeTestRepository.class})
public class ZAerospikeConfiguration {

	@Value("${aerospike.host:210.221.235.202}")
	private String aerospikeHost;

	@Value("${aerospike.port:3000}")
    private int aerospikePort;

	@Bean
	public AerospikeClient aerospikeClient() {

		ClientPolicy policy = new ClientPolicy();
		policy.failIfNotConnected = true ;

		return new AerospikeClient(policy, aerospikeHost, aerospikePort);
	}

	@Bean
	public AerospikeTemplate aerospikeTemplate() {
		return new AerospikeTemplate(this.aerospikeClient(),"test");
	}

	@Bean
	public AerospikeTemplate aerospikeTemplateAds() {
		return new AerospikeTemplate(this.aerospikeClient(),"ads");
	}


}
