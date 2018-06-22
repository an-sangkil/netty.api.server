package com.mezzomedia.core.model.common;

import com.mezzomedia.util.utils.json.JsonUtils;

public abstract class AbstractResponseObject<T> {

    private T object;

    /**
     * Response Data 객체에 대한 JSON STR 변환
     * @return
     * @throws Exception
     */
    public String toJsonString () throws Exception {
        return JsonUtils.convertJson(object);
    }


    public String toXMLString (T t) throws Exception {
        return "";
    }


    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

}
