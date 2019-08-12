package com.team.service;

import com.team.bean.ResponseOV;
import com.team.bean.Technology;
import com.team.bean.TechnologyRequirement;

import java.util.List;

public interface TechnologyRequirementService {
    TechnologyRequirement getTechnologyRequirementById(String id);

    ResponseOV<TechnologyRequirement> getTechnologyRequirementsById(int page, int rows);

    boolean insertTechnologyRequirement(TechnologyRequirement technologyRequirement);

    boolean deleteByIds(String[] ids);

    List<TechnologyRequirement> getTechnologyRequirements();

    boolean updateTechnologyRequirement(TechnologyRequirement technologyRequirement);

    boolean updateTechnologyRequirementNoteById(String technologyRequirementId, String note);

    ResponseOV<TechnologyRequirement> searchTechnologyRequirementByCondition(int flag, String searchValue, int page, int rows);
}
