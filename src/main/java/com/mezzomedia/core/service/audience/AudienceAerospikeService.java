package com.mezzomedia.core.service.audience;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mezzomedia.core.model.dto.audience.ADIDTarget;
import com.mezzomedia.core.model.dto.audience.Audience;
import com.mezzomedia.core.model.dto.audience.Category;
import com.mezzomedia.core.model.dto.audience.Retarget;
import com.mezzomedia.core.repository.aerospike.AudienceAerospikeRepository;

@Service
public class AudienceAerospikeService {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	private AudienceAerospikeRepository audienceAerospikeRepository;

	public Audience save (Audience audience) throws Exception {
		
		Map<String, String> frequency = new HashMap<>();
		frequency.put("62263", "1");

		List<Audience> audiences = new ArrayList<>();
		
		for (int i=0 ; i < 10000000 ; i ++) {
			audience= new Audience();
			audience.setAdidTarget(new ADIDTarget());
			audience.setCategory(new Category());
			audience.setRetarget(new Retarget());
			audience.setFrequency(frequency);
			audience.setAdid(UUID.randomUUID().toString());
			audiences.add(audience);
			
			if(i%1000 == 0 && i > 0) {
				audienceAerospikeRepository.saveAll(audiences);
				audiences.clear();
				logger.info("{} 건 등록" , i);
				
			}
			
		}
		
		
		
		
		
		return audience;
		
	}
	

}
