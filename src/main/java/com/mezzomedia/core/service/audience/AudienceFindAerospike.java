package com.mezzomedia.core.service.audience;

import com.mezzomedia.core.repository.aerospike.AudienceAerospikeRepository;
import com.mezzomedia.server.template.AbstractApiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <pre>
 * Description :
 * @author mezzomedia
 * @since 2018.06.14
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
@Service
public class AudienceFindAerospike extends AbstractApiRequest {

    @Autowired  private AudienceAerospikeRepository audienceAerospikeRepository;

    public AudienceFindAerospike(Map<String, String> reqData) {
        super(reqData);
    }

    @Override
    public void parameterValidation() throws Exception {

    }

    @Override
    public void service(Object o) throws Exception {

    }

    @Override
    public void responseResult() throws Exception {

    }


//    @Override
//    public void service() throws Exception {
//
//        Audience audience =  audienceAerospikeRepository.findOne();
//
//
//    }


}
