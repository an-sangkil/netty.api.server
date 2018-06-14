package com.mezzomedia.server.template;

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
public abstract class AbstractApiRequest<T> implements ApiRequest<T> {

    protected Map<String, String> reqData;

    public AbstractApiRequest(Map<String, String> reqData) {
        this.reqData = reqData;
    }

    @Override
    public void executeService(T t) throws Exception {

    }




}
