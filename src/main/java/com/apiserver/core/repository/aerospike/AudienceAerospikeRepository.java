package com.apiserver.core.repository.aerospike;

import org.springframework.data.aerospike.repository.AerospikeRepository;

import com.apiserver.core.model.dto.audience.Audience;

public interface AudienceAerospikeRepository extends AerospikeRepository<Audience, String>{

}
