package com.mezzomedia.core.repository.mybatis;

import com.mezzomedia.core.model.domain.object.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * <pre>
 * Description :
 * @author mezzomedia
 * @since 2018.04.18
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
@Mapper
public interface MybitisUserMapper {

    public List<User> userList() throws DataAccessException;
}
