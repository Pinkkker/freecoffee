package com.pink.forum.service;

import com.pink.forum.entity.Comment;
import com.pink.forum.entity.Post;
import com.pink.forum.message.Result;

/**
 * @author dengpengfei
 */

public interface PostService {
    Result selectAll(int pageSize, int pageNum);

    Result selectIdAll(int pageSize, int pageNum, int userId);

    Result selectById(int id);

    void insertSelective(Post record);

    Result deleteByPrimaryKey(Integer id);

    Result updateByPrimaryKey(Post record);
}