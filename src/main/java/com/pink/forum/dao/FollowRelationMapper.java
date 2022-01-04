package com.pink.forum.dao;

import com.pink.forum.entity.FollowRelation;
import com.pink.forum.entity.FollowRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FollowRelationMapper {
    long countByExample(FollowRelationExample example);

    int deleteByExample(FollowRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FollowRelation record);

    int insertSelective(FollowRelation record);

    List<FollowRelation> selectByExample(FollowRelationExample example);

    FollowRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FollowRelation record, @Param("example") FollowRelationExample example);

    int updateByExample(@Param("record") FollowRelation record, @Param("example") FollowRelationExample example);

    int updateByPrimaryKeySelective(FollowRelation record);

    int updateByPrimaryKey(FollowRelation record);
}