package com.team.service;

import com.team.bean.ResponseOV;
import com.team.bean.TechnologyPlan;

public interface TechnologyPlanService {
    ResponseOV<TechnologyPlan> getPageTechnologyPlan(int index, int pageSize);
}
