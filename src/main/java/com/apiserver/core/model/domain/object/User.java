package com.apiserver.core.model.domain.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * <pre>
 * Description : 일반 도메인 유저 객체
 * @author mezzomedia
 * @since 2018.04.18
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */

@JsonIgnoreProperties(ignoreUnknown = true, value = {"snsInterfaceInfos", "paymentInfomations"})
public class User implements Serializable {

    private String userId;
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
