package com.myhexin.tokenverification.service;

import com.myhexin.tokenverification.mapper.UserMapper;
import com.myhexin.tokenverification.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    public User findUserById(String id) {
        return userMapper.queryUserById(id);
    }

    public User findByUsername(User user) {
        return userMapper.queryUserByUsername(user);
    }
}
