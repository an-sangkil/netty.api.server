package com.mezzomedia.core.repository.mybatis;

import com.mezzomedia.core.model.domain.object.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * <pre>
 * Description :
 *              인터 페이스 클레스 명, 패키지명은  MapperClass를 바라보는 XML설정과 동일하게 해주어야 한다.
 * @author mezzomedia
 * @since 2018.04.18
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
@Mapper
public interface MybatisUserMapper {

    public List<User> userList() throws DataAccessException;
}
