package com.team.service;

import com.team.bean.ResponseOV;
import com.team.bean.TechnologyPlan;
import com.team.mapper.TechnologyPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService{

    @Autowired
    private TechnologyPlanMapper technologyPlanMapper;

    @Override
    public ResponseOV<TechnologyPlan> getPageTechnologyPlan(int index, int pageSize) {

        ResponseOV<TechnologyPlan> technologyPlanResponseOV=new ResponseOV<>();
        long l=technologyPlanMapper.countByExample(null);
        List<TechnologyPlan> pageTechnologyPlan=technologyPlanMapper.getPageTechnologyPlan((index-1)*pageSize,pageSize);
        technologyPlanResponseOV.setTotal((int) l);
        technologyPlanResponseOV.setRows(pageTechnologyPlan);
        return technologyPlanResponseOV;

    }

    @Override
    public TechnologyPlan getTechnologyPlanById(String id) {
        TechnologyPlan technologyPlanById=technologyPlanMapper.getTechnologyPlanById(id);
        return technologyPlanById;
    }

    @Override
    public List<TechnologyPlan> getTechnologyPlans() {
        List<TechnologyPlan> technologyPlans=technologyPlanMapper.getTechnologyPlans();
        return technologyPlans;
    }
}
