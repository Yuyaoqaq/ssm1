package com.cy.mapper;

import com.cy.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User findUserByLogin(@Param("username")String username,@Param("password") String password);

}
