package com.team.service;

import com.team.bean.Material;
import com.team.bean.MaterialExample;

import java.util.List;

public interface MaterialService {
    long countByExample(MaterialExample example);

    List<Material> selectByExample(MaterialExample example);
}
