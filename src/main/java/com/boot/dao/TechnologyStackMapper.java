package com.boot.dao;

import com.example.gitforum.TechnologyStack;
import com.example.gitforum.TechnologyStackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechnologyStackMapper {
    long countByExample(TechnologyStackExample example);

    int deleteByExample(TechnologyStackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TechnologyStack record);

    int insertSelective(TechnologyStack record);

    List<TechnologyStack> selectByExample(TechnologyStackExample example);

    TechnologyStack selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TechnologyStack record, @Param("example") TechnologyStackExample example);

    int updateByExample(@Param("record") TechnologyStack record, @Param("example") TechnologyStackExample example);

    int updateByPrimaryKeySelective(TechnologyStack record);

    int updateByPrimaryKey(TechnologyStack record);
}