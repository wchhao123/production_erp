package com.team.service;

import com.team.bean.Custom;
import com.team.bean.ResponseOV;
import com.team.bean.Technology;

import java.util.List;

public interface TechnologyService {
    //根据ID获取Technology
    Technology getTechnologyById(String id);

    ResponseOV<Technology> getTechnologies(int page, int rows);

    List<Technology> getTechnologies();

    boolean insertTechnology(Technology technology);

    boolean deleteByIds(String[] ids);

    boolean updateTechnology(Technology technology);

    boolean updateTechnologyNoteById(String technologyId, String note);

    ResponseOV<Technology> searchTechnologyByCondition(int flag, String searchValue, int page, int rows);
}
