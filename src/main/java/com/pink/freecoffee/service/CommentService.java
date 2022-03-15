package com.pink.freecoffee.service;

import com.pink.freecoffee.entity.Comment;
import com.pink.freecoffee.message.Result;

public interface CommentService {

    Result selectAll(int pageSize, int pageNum, int postId);

    Result selectById(int id);

    void insertSelective(Comment record);

    Result deleteByPrimaryKey(Integer id);

    Result updateByPrimaryKey(Comment record);
}
