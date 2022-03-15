package com.pink.freecoffee.service;

import com.pink.freecoffee.entity.TechnologyStack;
import java.util.List;

public interface UTRService {

    List<TechnologyStack> selectByUserId(int id);

    int createUTR(int userId, int TecId);

    int deleteUTR(int userId, int TecId);

}
