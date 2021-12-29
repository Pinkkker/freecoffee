package com.pink.forum.dao;

import com.pink.forum.entity.Comment;
import com.pink.forum.entity.CommentExample;
import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}