package com.mezzomedia.repository.aerospike;

import com.mezzomedia.model.dto.AerospikeProduct;
import org.springframework.data.aerospike.repository.AerospikeRepository;

public interface AerospikeTestRepository extends AerospikeRepository<AerospikeProduct, Integer>{

}
