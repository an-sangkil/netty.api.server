package com.mezzomedia.core.repository.aerospike;

import org.springframework.data.aerospike.repository.AerospikeRepository;

import com.mezzomedia.core.model.dto.demo.AerospikeProduct;

public interface AerospikeTestRepository extends AerospikeRepository<AerospikeProduct, Integer>{

}
