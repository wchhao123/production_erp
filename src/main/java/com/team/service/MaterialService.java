package com.team.service;

import com.team.bean.COrder;
import com.team.bean.Material;
import com.team.bean.MaterialExample;
import com.team.bean.ResponseOV;

import java.util.List;

public interface MaterialService {
    long countByExample(MaterialExample example);

    List<Material> selectByExample(MaterialExample example);

    ResponseOV<Material> getPageMaterial(int page, int rows);

    Material selectByPrimaryKey(String materialId);
}
