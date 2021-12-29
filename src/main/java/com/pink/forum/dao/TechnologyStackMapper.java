package com.pink.forum.dao;

import com.pink.forum.entity.TechnologyStack;
import com.pink.forum.entity.TechnologyStackExample;
import java.util.List;

public interface TechnologyStackMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(TechnologyStack record);

    int insertSelective(TechnologyStack record);

    List<TechnologyStack> selectByExample(TechnologyStackExample example);

    TechnologyStack selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(TechnologyStack record);

    int updateByPrimaryKey(TechnologyStack record);
}