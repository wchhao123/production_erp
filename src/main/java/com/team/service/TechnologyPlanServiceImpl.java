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
        /*ResponseOV<Process> processResponse = new ResponseOV<>();
        long l = processMapper.countByExample(null);
        List<Process> pageProcess=processMapper.getPageProcess((index-1)*pageSize,pageSize);
        processResponse.setTotal((int) l);
        processResponse.setRows(pageProcess);
        return processResponse;*/

        ResponseOV<TechnologyPlan> technologyPlanResponseOV=new ResponseOV<>();
        long l=technologyPlanMapper.countByExample(null);
        List<TechnologyPlan> pageTechnologyPlan=technologyPlanMapper.getPageTechnologyPlan((index-1)*pageSize,pageSize);
        technologyPlanResponseOV.setTotal((int) l);
        technologyPlanResponseOV.setRows(pageTechnologyPlan);
        return technologyPlanResponseOV;
      //return null;
    }
}
