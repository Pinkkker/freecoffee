package com.pink.freecoffee.service.impl;

import com.pink.freecoffee.dao.UserMapper;
import com.pink.freecoffee.entity.User;
import com.pink.freecoffee.entity.UserExample;
import com.pink.freecoffee.service.UserService;
import com.pink.freecoffee.shiro.ShiroUtils;
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
    public User selectById(int id) {
        return userMapper.selectByPrimaryKey(id);
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
        if (nickName != null) {
            user.setNickname(nickName);
        } else {
            user.setNickname(username);
        }
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateAvatar(String name) {
        User user = ShiroUtils.getUser();
        user.setAvatar(name);
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int githubRegister(String username, String userId, String userAvatar) {
        User user = new User();
        user.setName(username);
        //默认密码123456
        user.setPassword("123456");
        user.setNickname(username);
        user.setUserId(userId);
        user.setAvatar(userAvatar);

        return userMapper.insertSelective(user);
    }
}
