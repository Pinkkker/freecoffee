package com.pink.forum.service;

import com.pink.forum.entity.User;

import java.util.List;

public interface UserService {

    List<User> selectAll();

    User selectByName(String name);

    User updateByPrimaryKeySelective(User record);

    int register(String username, String password);
}
