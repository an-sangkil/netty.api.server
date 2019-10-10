package com.netty.api.core.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netty.api.core.model.dto.demo.AerospikeProduct;
import com.netty.api.core.repository.aerospike.AerospikeTestRepository;

@Service
public class AerospikeService {


	private Logger logger = LoggerFactory.getLogger(AerospikeService.class);

	@Autowired public AerospikeTestRepository aerospikeRepository;

	/**
	 * Aerospike save Test
	 * @return
	 */
	public <T> T save(T t) {
		AerospikeProduct ap = new  AerospikeProduct();

		//org.apache.log4j.Logger;
		//org.apache.logging.log4j.Logger;
		ap.setId(1);
		ap.setProductId("mezzo");
		ap.setImageUrl("http://");
		ap.setPrice(500000);
		ap.setDescription("Aerospike Test.....");

		this.aerospikeRepository.save(ap);

		AerospikeProduct aerospikeProduct = this.aerospikeRepository.findOne(3);

		// Spring Data 2 version
		// Optional<AerospikeProduct> aerospikeProduct  = this.aerospikeRepository.findById(1);
		// logger.debug("AerospikeProduct = {}" , aerospikeProduct.get());


		return t;
	}

	public void findData () {
		List<AerospikeProduct> aerospikeProducts = (List<AerospikeProduct>) this.aerospikeRepository.findAll();
		logger.debug("aerospikeProducts size", aerospikeProducts .size());
	}



}
