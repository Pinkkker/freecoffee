package com.pink.forum.dao;

import com.pink.forum.entity.UserStarPostRelation;
import com.pink.forum.entity.UserStarPostRelationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserStarPostRelationMapper {
    long countByExample(UserStarPostRelationExample example);

    int deleteByExample(UserStarPostRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserStarPostRelation record);

    int insertSelective(UserStarPostRelation record);

    List<UserStarPostRelation> selectByExample(UserStarPostRelationExample example);

    UserStarPostRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserStarPostRelation record, @Param("example") UserStarPostRelationExample example);

    int updateByExample(@Param("record") UserStarPostRelation record, @Param("example") UserStarPostRelationExample example);

    int updateByPrimaryKeySelective(UserStarPostRelation record);

    int updateByPrimaryKey(UserStarPostRelation record);
}