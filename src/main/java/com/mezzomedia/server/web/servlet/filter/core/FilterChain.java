package com.mezzomedia.server.web.servlet.filter.core;

import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Description :
 * @author skan
 * @since 2018.05.02
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public class FilterChain {

    private List<Filter>  filters = new ArrayList<>();
    private Target target;
    private Class<?> cls;

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    /**
     * Filter 순차 실행
     *
     * 최종 execute , request handler
     * @param httpRequest
     * @throws Exception 
     */
    public void execute(HttpRequest httpRequest , HttpResponse response) throws Exception {

        // 1. 필터 전차리 순차 실행
        for (Filter filter : filters ) {
            boolean preBoolean =  filter.execute(httpRequest, response);
            if(!preBoolean) {
            	
            	//throw new Exception(" Filter execute : ");
            	
            }
        }

        // 필터 완료 후 실행될  Class 호출
        target.execute(httpRequest, response);

        // 2. 필터 후처리 순차실행
        for (Filter filter: filters)  {
            filter.postProcessing(httpRequest, response);
        }

        //cls.getMethods();
    }

    public void setTarget(Target target){
        this.target = target;
    }



}
