package com.pink.forum.service;

import com.pink.forum.entity.User;

public interface UserService {

    User selectByName(String name);

}
