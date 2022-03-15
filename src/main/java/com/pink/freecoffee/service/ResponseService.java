package com.pink.freecoffee.service;

import com.pink.freecoffee.entity.Response;
import com.pink.freecoffee.message.Result;

/**
 * @author dengpengfei
 */

public interface ResponseService {
    Result selectById(int id);

    void insertSelective(Response record);

    Result deleteByPrimaryKey(Integer id);
}
