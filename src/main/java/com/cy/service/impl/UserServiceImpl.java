package com.cy.service.impl;

import com.cy.mapper.UserMapper;
import com.cy.model.User;
import com.cy.service.UserService;
import com.cy.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultData findUserByLogin(String username, String password) {
        User user = userMapper.findUserByLogin(username, password);
        if(user != null) {
            return ResultData.ok(user);
        }else{
            return ResultData.fail();
        }
    }
}
