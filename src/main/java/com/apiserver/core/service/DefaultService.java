package com.apiserver.core.service;

import com.apiserver.core.code.CommonCode;
import com.apiserver.server.template.AbstractApiTemplate;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <pre>
 * Description :
 * @author mezzomedia
 * @since 2018.06.15
 * @version
 *
 * Copyright (C) 2018 by CJENM|Mezzimedia.Inc. All right reserved.
 */
@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DefaultService extends AbstractApiTemplate {

    public DefaultService(Map reqData) {
        super(reqData);
    }

    @Override
    public void requestParamValidation() throws Exception {

    }

    @Override
    public void service() throws Exception {

        this.responseResult.setResponseMessage("요청된 URL 페이지가 없습니다.  404");
        this.responseResult.setStateCode(CommonCode.FAIL);


    }
}
