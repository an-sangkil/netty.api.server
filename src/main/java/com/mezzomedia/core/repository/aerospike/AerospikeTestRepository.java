package com.mezzomedia.core.repository.aerospike;

import com.mezzomedia.core.model.dto.AerospikeProduct;
import org.springframework.data.aerospike.repository.AerospikeRepository;

public interface AerospikeTestRepository extends AerospikeRepository<AerospikeProduct, Integer>{

}
