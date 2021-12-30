package com.pink.forum.service;

import com.pink.forum.entity.Comment;
import com.pink.forum.message.Result;

public interface CommentService {

    Result selectAll(int pageSize, int pageNum, int postId);

    Result selectById(int id);

    void insertSelective(Comment record);

    Result deleteByPrimaryKey(Integer id);

    Result updateByPrimaryKey(Comment record);
}
