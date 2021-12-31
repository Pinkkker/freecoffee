package com.pink.forum.dao;

import com.pink.forum.entity.UserTecRelation;
import com.pink.forum.entity.UserTecRelationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserTecRelationMapper {
    long countByExample(UserTecRelationExample example);

    int deleteByExample(UserTecRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserTecRelation record);

    int insertSelective(UserTecRelation record);

    List<UserTecRelation> selectByExample(UserTecRelationExample example);

    UserTecRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserTecRelation record, @Param("example") UserTecRelationExample example);

    int updateByExample(@Param("record") UserTecRelation record, @Param("example") UserTecRelationExample example);

    int updateByPrimaryKeySelective(UserTecRelation record);

    int updateByPrimaryKey(UserTecRelation record);
}