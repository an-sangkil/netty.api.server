package com.apiserver.core.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.apiserver.model.LogModel;
import com.apiserver.server.template.AbstractApiTemplate;
import com.apiserver.service.KafkaHandler;
import com.apiserver.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * <pre>
 * Description :
 *
 *
 * </pre>
 *
 * @author skan
 * @version Copyright (C) 2019 by CJENM|Mezzomedia. All right reserved.
 * @since 2019-11-26
 */
@Service
@Scope("prototype")
public class KafkaService extends AbstractApiTemplate {

    @Autowired
    KafkaProducerService kafkaProducerService;

    public KafkaService(Map reqData) {
        super(reqData);
    }

    @Override
    public void requestParamValidation() throws Exception {

    }

    @Override
    public void service() throws Exception {
        String param1 = (String) reqData.get("param1");
        LogModel logModel = new LogModel("", param1, LocalDateTime.now());
        ObjectMapper objectMapper = new ObjectMapper();
        String data = objectMapper.writeValueAsString(logModel);
        kafkaProducerService.sender(KafkaHandler.TOPIC_NAME, data);
    }
}
