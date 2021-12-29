package com.pink.forum.dao;

import com.pink.forum.entity.Post;
import com.pink.forum.entity.PostExample;
import java.util.List;

public interface PostMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Post record);

    int insertSelective(Post record);

    List<Post> selectByExample(PostExample example);

    Post selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);
}