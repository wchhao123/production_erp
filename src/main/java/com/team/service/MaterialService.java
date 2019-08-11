package com.team.service;

import com.team.bean.Material;
import com.team.bean.MaterialExample;
import com.team.bean.ResponseOV;

import java.util.List;

public interface MaterialService {
    long countByExample(MaterialExample example);

    List<Material> selectByExample();

    ResponseOV<Material> getPageMaterial(int page, int rows);

    Material selectByPrimaryKey(String materialId);

    boolean insert(Material record);

    boolean deleteByPrimaryKey(String materialId);

    boolean updateByPrimaryKey(Material record);

    ResponseOV<Material> searchMaterialByCondition(int flag, String searchValue, int page, int rows);
}
