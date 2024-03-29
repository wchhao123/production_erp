package com.team.service;

import com.team.bean.ResponseOV;
import com.team.bean.TechnologyPlan;

import java.util.List;

public interface TechnologyPlanService {

    ResponseOV<TechnologyPlan> getPageTechnologyPlan(int index, int pageSize);

    TechnologyPlan getTechnologyPlanById(String id);

    List<TechnologyPlan> getTechnologyPlans();

    boolean insertTechnologyPlan(TechnologyPlan technologyPlan);

    boolean deleteByIds(String[] ids);

    boolean updateTechnologyPlan(TechnologyPlan technologyPlan);

    boolean updateTechnologyPlanNoteById(String technologyPlanId, String note);

    ResponseOV<TechnologyPlan> searchTechnologyPlanByCondition(int flag, String searchValue, int page, int rows);
}
