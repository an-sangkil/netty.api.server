package com.mezzomedia.core.repository.aerospike;

import org.springframework.data.aerospike.repository.AerospikeRepository;

import com.mezzomedia.core.model.dto.audience.Audience;

public interface AudienceAerospikeRepository extends AerospikeRepository<Audience, String>{

}
