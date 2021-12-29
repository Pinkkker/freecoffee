package com.pink.forum.service.impl;

import com.pink.forum.dao.UserMapper;
import com.pink.forum.entity.User;
import com.pink.forum.entity.UserExample;
import com.pink.forum.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    final UserMapper userMapper;

    @Override
    public User selectByName(String name) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.isEmpty()) {
            return null;
        } else {
            return users.get(0);
        }
    }

    @Override
    public void updateByPrimaryKeySelective(User record) {
        userMapper.updateByPrimaryKeySelective(record);
    }
}
