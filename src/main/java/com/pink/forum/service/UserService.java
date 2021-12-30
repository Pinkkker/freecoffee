package com.pink.forum.service;

import com.pink.forum.entity.User;

public interface UserService {

    User selectByName(String name);

    User updateByPrimaryKeySelective(User record);

    int register(String username, String password);
}
