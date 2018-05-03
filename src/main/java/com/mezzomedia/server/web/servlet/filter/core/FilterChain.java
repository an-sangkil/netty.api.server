package com.mezzomedia.server.web.servlet.filter;

import io.netty.handler.codec.http.HttpRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Description :
 * @author mezzomedia
 * @since 2018.05.02
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public class FilterChain {

    private List<Filter>  filters = new ArrayList<>();
    private Target target;

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    /**
     * Filter 순차 실행
     *
     * 최종 execute , request handler
     * @param httpRequest
     */
    public void execute(HttpRequest httpRequest) {
        // 필터 순차 실행
        for (Filter filter : filters ) {
            filter.execute(httpRequest);
        }
        // 필터 완료 후 실행될  Class 호출
        target.execute(httpRequest);
    }

    public void setTarget(Target target){
        this.target = target;
    }



}
