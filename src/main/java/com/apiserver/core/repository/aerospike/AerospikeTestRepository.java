package com.apiserver.core.repository.aerospike;

import org.springframework.data.aerospike.repository.AerospikeRepository;

import com.apiserver.core.model.dto.demo.AerospikeProduct;

public interface AerospikeTestRepository extends AerospikeRepository<AerospikeProduct, Integer>{

}
