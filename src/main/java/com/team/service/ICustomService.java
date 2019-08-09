package com.team.service;

import com.team.bean.Custom;
import com.team.bean.ResponseOV;

public interface ICustomService {

    //根据ID获取Custom
    Custom getCustomById(String id);

    ResponseOV<Custom> getCustoms(int page, int rows);
}
