package com.apiserver.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <pre>
 * Description :
 *
 *
 * </pre>
 *
 * @author skan
 * @version Copyright (C) 2019 by CJENM|Mezzomedia. All right reserved.
 * @since 2019-11-25
 */
@Data
public class LogModel {

    private final String id;
    private final String value;
    private String data;
    private final LocalDateTime time;

    public String toJson() {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return null;
        }

    }

}
