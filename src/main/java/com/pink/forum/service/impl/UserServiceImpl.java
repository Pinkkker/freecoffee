package com.pink.forum.service.impl;

import com.pink.forum.dao.UserMapper;
import com.pink.forum.entity.User;
import com.pink.forum.entity.UserExample;
import com.pink.forum.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectByExample(new UserExample()).stream().filter(user -> !user.getAuthorization().equals("root")).collect(Collectors.toList());
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
    public int deleteUser(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setStatus(1);
        return userMapper.updateByPrimaryKeySelective(user);
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
