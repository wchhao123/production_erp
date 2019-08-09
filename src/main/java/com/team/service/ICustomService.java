package com.team.service;


import com.team.bean.COrder;
import com.team.bean.Custom;
import com.team.bean.Product;
import com.team.bean.ResponseOV;

import java.util.List;

public interface ICustomService {

    //根据ID获取Custom
    Custom getCustomById(String id);

    ResponseOV<Custom> getCustoms(int page, int rows);

    List<Custom> getCustoms();

    boolean updateCustom(Custom custom);

    boolean deleteByIds(String[] ids);

    boolean insertCustom(Custom custom);

    ResponseOV<Custom> searchCustomByCondition(int flag, String searchValue, int page, int rows);
}
