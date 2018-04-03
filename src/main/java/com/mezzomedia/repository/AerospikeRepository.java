package com.mezzomedia.repository;

import com.mezzomedia.model.dto.AerospikeProduct;

public interface AerospikeRepository extends org.springframework.data.aerospike.repository.AerospikeRepository<AerospikeProduct, Integer>{

}
