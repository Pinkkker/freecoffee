package com.pink.freecoffee.service;

import com.pink.freecoffee.entity.User;
import java.util.List;

public interface UserService {

    List<User> selectAll();

    User selectById(int id);

    User selectByName(String name);

    User updateByPrimaryKeySelective(User record);

    int deleteUser(int id);

    int register(String username, String password, String nickName);

    int githubRegister(String username, String userId, String usrAvatar);

    int updateAvatar(String name);
}
