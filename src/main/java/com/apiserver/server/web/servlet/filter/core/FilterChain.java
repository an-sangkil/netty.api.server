package com.apiserver.server.web.servlet.filter.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.apiserver.core.model.common.AbstractResponseObject;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.LastHttpContent;

/**
 * <pre>
 * Description :
 * @author skan
 * @since 2018.05.02
 * @version
 *
 * Copyright (C) 2018 by CJENM|Mezzimedia.Inc. All right reserved.
 */
public class FilterChain<T> {

    private List<Filter>  filters = new ArrayList<>();
    private Target target;
    private Class<?> cls;

    public void addFilter(Filter filter) {
        filters.add(filter);
    }
   
    public void setTarget(Target target){
        this.target = target;
    }
    
    /**
     * Filter 순차 실행
     *
     * 최종 execute , request handler
     * @param httpRequest
     * @param requestData 
     * @throws Exception 
     */
	public AbstractResponseObject<T> execute(HttpRequest httpRequest, LastHttpContent lastHttpContent, ChannelHandlerContext ctx, Map<String, Object> requestData) throws Exception {
		
		// 1. 필터 전차리 순차 실행
        for (Filter filter : filters ) {
            boolean preBoolean =  filter.execute(httpRequest, lastHttpContent);
            if(!preBoolean) {
            	throw new Exception(" Filter execute : ");
            }
        }

        // 필터 완료 후 실행될  Class 호출
        AbstractResponseObject<T> t = target.execute(httpRequest, lastHttpContent, ctx, requestData);

        
        // 2. 필터 후처리 순차실행
        for (Filter filter: filters)  {
            filter.postProcessing(httpRequest, lastHttpContent);
        }
        
        //cls.getMethods();
		
        return t;
	}



}
