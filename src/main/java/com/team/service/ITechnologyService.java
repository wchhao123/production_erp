package com.team.service;

import com.team.bean.Custom;
import com.team.bean.ResponseOV;
import com.team.bean.Technology;

import java.util.List;

public interface ITechnologyService {
    //根据ID获取Technology
    Technology getTechnologyById(String id);

    ResponseOV<Technology> getTechnologies(int page, int rows);

    List<Technology> getTechnologies();
}
