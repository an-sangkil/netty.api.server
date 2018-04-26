package com.mezzomedia.server.web.servlet.handler;

import java.util.Map;

/**
 * <pre>
 * Description :
 * @author skan
 * @since 2018.04.26
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public abstract class AbstractDispatcherParameterParser {

    /**
     * GET parameter Key, Value 형태 전환
     * @param urlParameter
     * @return
     */
    public Map<String,Object> parameterGeneraterGET(String urlParameter) {

        return null;
    }

    /**
     * POST parameter Key, Value 형태 전환
     * @param bodyContents
     * @return
     */
    public Map<String,Object> parameterGeneraterPOST(String bodyContents) {

        return null;
    }

}
