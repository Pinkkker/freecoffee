package com.pink.freecoffee.service;

import com.pink.freecoffee.entity.Post;
import com.pink.freecoffee.message.Result;

/**
 * @author dengpengfei
 */

public interface PostService {
    Result selectAll(int pageSize, int pageNum);

    Result selectByUId(int userId);

    Result selectByKeyWord(String keyWord);

    Result selectById(int id);

    void insertSelective(Post record);

    Result deleteByPrimaryKey(Integer id);

    Result updateByPrimaryKey(Post record);

    void star(int postId);

    void unStar(int postId);
}
