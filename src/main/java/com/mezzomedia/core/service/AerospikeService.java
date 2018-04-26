package com.mezzomedia.core.service;

import java.util.List;

import com.mezzomedia.core.repository.aerospike.AerospikeTestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mezzomedia.core.model.dto.AerospikeProduct;

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

		//this.aerospikeRepository.save(ap);
		AerospikeProduct aerospikeProduct = this.aerospikeRepository.findOne(3);

		logger.debug("AerospikeProduct = {}" , aerospikeProduct.getId());

//		List<AerospikeProduct> aerospikeProducts =  (List<AerospikeProduct>) this.aerospikeRepository.findAll();
//		aerospikeProducts.forEach(productItem -> {
//			productItem.toString();
//			logger.debug("AerospikeProduct = {}" , ap.getDescription());
//		});

		return t;
	}



}
