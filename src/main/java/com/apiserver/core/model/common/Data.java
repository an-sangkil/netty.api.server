package com.apiserver.core.model.common;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * <pre>
 * Description :
 * @author mezzomedia
 * @since 2018.06.21
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public class Data<T> implements ReturnObject  {

    /** 응답시 넘겨줄 객체 를 제네릭으로 선언하여 사용한다. */
	@JsonUnwrapped
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
