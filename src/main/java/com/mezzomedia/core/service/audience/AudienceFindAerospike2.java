package com.mezzomedia.core.service.audience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mezzomedia.core.model.dto.audience.Audience;
import com.mezzomedia.core.repository.aerospike.AudienceAerospikeRepository;
import com.mezzomedia.server.template.AbstractApiRequest;

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
public class AudienceFindAerospike2 extends AbstractApiRequest<Audience> {


	@Autowired  private AudienceAerospikeRepository audienceAerospikeRepository;

	@Override
	public void parameterValidation(Audience t) throws Exception {
		
	}

	@Override
	public void service(Audience t) throws Exception {
		
		audienceAerospikeRepository.findOne(t.getAdid());
		
	}

	@Override
	public void requestParamValidation() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeService() {
		// TODO Auto-generated method stub
		
	}

	


}
