package com.myhexin.tokenverification.mapper;

import com.myhexin.tokenverification.model.User;

public interface UserMapper {
    User queryUserById(String id);

    User queryUserByUsername(User user);
}
