package com.netty.api.core.service.audience;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.netty.api.core.code.CommonCode;
import com.netty.api.core.model.common.Data;
import com.netty.api.core.model.dto.audience.Audience;
import com.netty.api.core.repository.aerospike.AudienceAerospikeRepository;
import com.netty.api.server.template.AbstractApiTemplate;

/**
 * <pre>
 * Description : 고객 정보 조회
 * @author skan
 * @since 2018.06.14
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
@Service
@Scope("prototype")
public class AudienceFindAerospike extends AbstractApiTemplate<Audience> {


	public AudienceFindAerospike(Map<String, Object> reqData) {
		super(reqData);
		// TODO Auto-generated constructor stub
	}

	@Autowired  private AudienceAerospikeRepository audienceAerospikeRepository;

	@Override
	public void requestParamValidation() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service() throws Exception {
		
		String adid = (String) reqData.get("adid");
		Audience audience =  audienceAerospikeRepository.findOne(adid);

		Data<Audience> data = new Data<>();
		data.setObject(audience);

		this.responseResult.setData(data);
		this.responseResult.setStateCode(CommonCode.SUCCESS);
		
		
	}

}
