package com.mezzomedia.core.service;

import java.util.List;
import java.util.Optional;

import com.mezzomedia.core.model.dto.demo.AerospikeProduct;
import com.mezzomedia.core.repository.aerospike.AerospikeTestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AerospikeService {


	private Logger logger = LoggerFactory.getLogger(AerospikeService.class);

	public AerospikeTestRepository aerospikeTestRepository;

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

		this.aerospikeTestRepository.save(ap);

		AerospikeProduct aerospikeProduct = this.aerospikeTestRepository.findById(3).get();

		// Spring Data 2 version
		// Optional<AerospikeProduct> aerospikeProduct  = this.aerospikeRepository.findById(1);
		// logger.debug("AerospikeProduct = {}" , aerospikeProduct.get());


		return t;
	}

	public void findData () {
		List<AerospikeProduct> aerospikeProducts = (List<AerospikeProduct>) this.aerospikeTestRepository.findAll();
		logger.debug("aerospikeProducts size", aerospikeProducts .size());
	}



}
