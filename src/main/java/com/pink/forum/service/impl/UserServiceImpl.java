package com.pink.forum.service.impl;

import com.pink.forum.dao.UserMapper;
import com.pink.forum.entity.User;
import com.pink.forum.entity.UserExample;
import com.pink.forum.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectByExample(new UserExample());
    }

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
    public User updateByPrimaryKeySelective(User record) {
        userMapper.updateByPrimaryKeySelective(record);
        return userMapper.selectByPrimaryKey(record.getId());
    }

    @Override
    public int register(String username, String password, String nickName) {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setNickName(nickName);
        return userMapper.insertSelective(user);
    }
}
