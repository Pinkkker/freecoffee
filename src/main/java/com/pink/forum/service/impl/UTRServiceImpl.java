package com.pink.forum.service.impl;

import com.pink.forum.dao.TechnologyStackMapper;
import com.pink.forum.dao.UserTecRelationMapper;
import com.pink.forum.entity.TechnologyStack;
import com.pink.forum.entity.UserTecRelation;
import com.pink.forum.entity.UserTecRelationExample;
import com.pink.forum.service.UTRService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UTRServiceImpl implements UTRService {

    final UserTecRelationMapper userTecRelationMapper;
    final TechnologyStackMapper technologyStackMapper;


    @Override
    public List<TechnologyStack> selectByUserId(int id) {
        UserTecRelationExample userTecRelationExample = new UserTecRelationExample();
        UserTecRelationExample.Criteria criteria = userTecRelationExample.createCriteria();
        criteria.andUser_idEqualTo(id);
        List<UserTecRelation> userTecRelations = userTecRelationMapper.selectByExample(userTecRelationExample);
        return userTecRelations.stream().map(u -> technologyStackMapper.selectByPrimaryKey(u.getTec_id())).collect(Collectors.toList());
    }

    @Override
    public int createUTR(int userId, int TecId) {
        UserTecRelation userTecRelation = new UserTecRelation();
        userTecRelation.setUser_id(userId);
        userTecRelation.setTec_id(TecId);
        return userTecRelationMapper.insertSelective(userTecRelation);
    }

    @Override
    public int deleteUTR(int userId, int TecId) {
        UserTecRelationExample userTecRelationExample = new UserTecRelationExample();
        UserTecRelationExample.Criteria criteria = userTecRelationExample.createCriteria();
        criteria.andUser_idEqualTo(userId);
        criteria.andTec_idEqualTo(TecId);
        return userTecRelationMapper.deleteByExample(userTecRelationExample);
    }
}
