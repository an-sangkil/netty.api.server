package com.netty.api.server.handler.channel;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.multipart.*;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * <pre>
 * Description : 요청 파라미터에 대한 파싱 처리
 * @author mezzomedia
 * @since 2018.05.04
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public abstract class AbstractRequestParameterParser extends SimpleChannelInboundHandler<FullHttpRequest>  implements RequestParameterParser {

    private Logger logger  = LoggerFactory.getLogger(AbstractRequestParameterParser.class);
    static final HttpDataFactory factory = new DefaultHttpDataFactory(DefaultHttpDataFactory.MINSIZE); // Disk

    /**
     * GET Data 에 대한 parameter parser
     */
    public void  readGetData(HttpRequest httpRequest, Map<String,Object> requestData ) {
        QueryStringDecoder queryStringDecoder = new QueryStringDecoder(httpRequest.uri(), CharsetUtil.UTF_8);
        queryStringDecoder.parameters().forEach((k,v) -> {

            v.forEach( itemValue -> {
                requestData.put(k , itemValue);
            });

        });
    }

    /**
     * Post Data 에 대한 request Parameter parser
     */
    public  void readPostData(HttpRequest httpRequest, Map<String,Object> requestData  ) {
        HttpPostRequestDecoder decoder = null;
        try {

            decoder = new HttpPostRequestDecoder(factory, httpRequest);
            for (InterfaceHttpData data : decoder.getBodyHttpDatas()) {
                if (InterfaceHttpData.HttpDataType.Attribute == data.getHttpDataType()) {
                    try {
                        Attribute attribute = (Attribute) data;
                        requestData.put(attribute.getName(), attribute.getValue());
                    }
                    catch (IOException e) {
                        logger.error("BODY Attribute: " + data.getHttpDataType().name(), e);
                        return;
                    }
                }
                else {
                    logger.info("BODY data : " + data.getHttpDataType().name() + ": " + data);
                }
            }

        } catch (HttpPostRequestDecoder.ErrorDataDecoderException e) {
            logger.error("readPostData error = { } ",e);
        } finally {
            if (decoder != null) {
                decoder.destroy();
            }
        }
    }


}
