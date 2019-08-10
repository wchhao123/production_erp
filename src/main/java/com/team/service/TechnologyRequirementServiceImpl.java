package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.ResponseOV;
import com.team.bean.Technology;
import com.team.bean.TechnologyRequirement;
import com.team.mapper.TechnologyMapper;
import com.team.mapper.TechnologyRequirementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyRequirementServiceImpl implements ITechnologyRequirementService{
    @Autowired
    private TechnologyRequirementMapper technologyRequirementMapper;

    @Override
    public TechnologyRequirement getTechnologyRequirementById(String id) {
        return technologyRequirementMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResponseOV<TechnologyRequirement> getTechnologyRequirementsById(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.mixTechnologyRequirement();
        PageInfo<TechnologyRequirement> pageInfo = new PageInfo<>(technologyRequirements);
        long total = pageInfo.getTotal();

        ResponseOV<TechnologyRequirement> ov = new ResponseOV<>();
        ov.setTotal((int) total);
        ov.setRows(technologyRequirements);
        return ov;
    }
}
