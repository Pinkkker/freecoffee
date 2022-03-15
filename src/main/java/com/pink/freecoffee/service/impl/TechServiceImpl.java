package com.pink.freecoffee.service.impl;

import com.pink.freecoffee.dao.TechnologyStackMapper;
import com.pink.freecoffee.entity.TechnologyStack;
import com.pink.freecoffee.entity.TechnologyStackExample;
import com.pink.freecoffee.service.TechService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TechServiceImpl implements TechService {

    final TechnologyStackMapper technologyStackMapper;


    @Override
    public List<TechnologyStack> selectAll() {
        TechnologyStackExample technologyStackExample = new TechnologyStackExample();
        TechnologyStackExample.Criteria criteria = technologyStackExample.createCriteria();
        criteria.andStatusEqualTo(0);
        return technologyStackMapper.selectByExample(technologyStackExample);
    }

    @Override
    public int createTec(TechnologyStack technologyStack) {
        return technologyStackMapper.insertSelective(technologyStack);
    }

    @Override
    public int deleteTec(int id) {
        return technologyStackMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateTec(TechnologyStack technologyStack) {
        return technologyStackMapper.updateByPrimaryKeySelective(technologyStack);
    }
}
