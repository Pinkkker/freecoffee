package com.pink.forum.service;

import com.pink.forum.entity.Response;
import com.pink.forum.message.Result;

/**
 * @author dengpengfei
 */

public interface ResponseService {
    Result selectById(int id);

    void insertSelective(Response record);

    Result deleteByPrimaryKey(Integer id);
}
