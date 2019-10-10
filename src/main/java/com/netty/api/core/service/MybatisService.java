package com.netty.api.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netty.api.core.model.domain.object.User;
import com.netty.api.core.repository.mybatis.MybatisUserMapper;

/**
 * <pre>
 * Description :
 * @author mezzomedia
 * @since 2018.04.18
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
@Service
public class MybatisService {

    @Autowired
    private MybatisUserMapper mybatisUserMapper;

    public List<User> findUserList(){
        List<User>  users = this.mybatisUserMapper.userList();
        return users;
    }
}
