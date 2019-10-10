package com.netty.api.core.repository.aerospike;

import org.springframework.data.aerospike.repository.AerospikeRepository;
import com.netty.api.core.model.dto.audience.Audience;

public interface AudienceAerospikeRepository extends AerospikeRepository<Audience, String>{

}
