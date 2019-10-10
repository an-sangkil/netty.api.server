package com.netty.api.core.repository.aerospike;

import org.springframework.data.aerospike.repository.AerospikeRepository;
import com.netty.api.core.model.dto.demo.AerospikeProduct;

public interface AerospikeTestRepository extends AerospikeRepository<AerospikeProduct, Integer>{

}
