package com.pink.forum.dao;

import com.pink.forum.entity.Response;
import com.pink.forum.entity.ResponseExample;
import java.util.List;

public interface ResponseMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Response record);

    int insertSelective(Response record);

    List<Response> selectByExample(ResponseExample example);

    Response selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Response record);

    int updateByPrimaryKey(Response record);
}