package com.pink.forum.service;

import com.pink.forum.entity.TechnologyStack;
import com.pink.forum.entity.UserTecRelation;

import java.util.List;

public interface UTRService {

    List<TechnologyStack> selectByUserId(int id);

    int createUTR(int userId, int TecId);

    int deleteUTR(int userId, int TecId);

}
