package com.team.service;

import com.team.bean.ResponseOV;
import com.team.bean.Technology;
import com.team.bean.TechnologyRequirement;

public interface ITechnologyRequirementService {
    TechnologyRequirement getTechnologyRequirementById(String id);

    ResponseOV<TechnologyRequirement> getTechnologyRequirementsById(int page, int rows);
}
