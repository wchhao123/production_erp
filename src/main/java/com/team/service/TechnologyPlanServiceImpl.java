package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.*;
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

    @Override
    public boolean insertTechnologyPlan(TechnologyPlan technologyPlan) {
        return technologyPlanMapper.insert(technologyPlan) == 1;
    }

    @Override
    public boolean deleteByIds(String[] ids) {
        return technologyPlanMapper.batchDeleteByIds(ids) != 0;
    }

    @Override
    public boolean updateTechnologyPlan(TechnologyPlan technologyPlan) {
        int i = technologyPlanMapper.updateByPrimaryKey(technologyPlan);
        return i == 1;
    }

    @Override
    public boolean updateTechnologyPlanNoteById(String technologyPlanId, String note) {
        TechnologyPlan technologyPlan=new TechnologyPlan();
        technologyPlan.setTechnologyPlanId(technologyPlanId);
        technologyPlan.setNote(note);
        int i = technologyPlanMapper.updateByPrimaryKeySelective(technologyPlan);
        return i == 1;
    }

    @Override
    public ResponseOV<TechnologyPlan> searchTechnologyPlanByCondition(int flag, String searchValue, int page, int rows) {
        TechnologyPlanExample technologyPlan = new TechnologyPlanExample();
        PageHelper.startPage(page, rows);
        if (flag == 1) {
            technologyPlan.createCriteria().andTechnologyPlanIdLike("%" + searchValue + "%");
        } else {
            technologyPlan.createCriteria().andTechnologyPlanNameLike("%" + searchValue + "%");
        }
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.selectByExample(technologyPlan);
        PageInfo<TechnologyPlan> info = new PageInfo<>(technologyPlans);

        ResponseOV<TechnologyPlan> ov = new ResponseOV<>();
        ov.setRows(technologyPlans);
        ov.setTotal((int) info.getTotal());
        return ov;
    }
}
