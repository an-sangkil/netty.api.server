package com.mezzomedia.core.model.common;

public abstract class AbstractResponseObject<T> {


    /**
     * Response Data 객체에 대한 JSON STR 변환
     * @throws Exception
     */
    public abstract String toJsonString () throws Exception;
    
    /**
     * Response Data 객체에 대한 XML STR 변환
     * @throws Exception
     */
    public abstract String toXMLString () throws Exception;

}
