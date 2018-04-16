package com.mezzomedia.service;

import java.util.List;

import com.mezzomedia.repository.aerospike.AerospikeTestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mezzomedia.model.dto.AerospikeProduct;

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

		ap.setId(3);
		ap.setProductId("mezzo");
		ap.setImageUrl("http://");
		ap.setPrice(500000);
		ap.setDescription("Aerospike Test.....");

		this.aerospikeRepository.save(ap);

		logger.debug("AerospikeProduct = {}" , ap.getId());

		List<AerospikeProduct> aerospikeProducts =  (List<AerospikeProduct>) this.aerospikeRepository.findAll();
		aerospikeProducts.forEach(productItem -> {
			productItem.toString();
			logger.debug("AerospikeProduct = {}" , ap.getDescription());
		});

		return t;
	}



}
