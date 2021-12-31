package com.pink.forum.service;

import com.pink.forum.entity.TechnologyStack;

import java.util.List;

public interface TechService {
    List<TechnologyStack> selectAll();

    int createTec(TechnologyStack technologyStack);

    int deleteTec(int id);

    int updateTec(TechnologyStack technologyStack);
}
