package com.pink.forum.dao;

import com.pink.forum.entity.User;
import com.pink.forum.entity.UserExample;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}