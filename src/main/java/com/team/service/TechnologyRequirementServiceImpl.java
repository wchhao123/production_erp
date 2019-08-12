package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.ProcessExample;
import com.team.bean.ResponseOV;
import com.team.bean.TechnologyRequirement;
import com.team.bean.TechnologyRequirementExample;
import com.team.mapper.TechnologyRequirementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {
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

    @Override
    public boolean insertTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        return technologyRequirementMapper.insert(technologyRequirement) == 1;
    }

    @Override
    public boolean deleteByIds(String[] ids) {

        return technologyRequirementMapper.batchDeleteByIds(ids) != 0;
    }

    @Override
    public List<TechnologyRequirement> getTechnologyRequirements() {
        return technologyRequirementMapper.selectByUpdate(null);
    }

    @Override
    public boolean updateTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        int i = technologyRequirementMapper.updateByPrimaryKey(technologyRequirement);
        return i == 1;
    }

    @Override
    public boolean updateTechnologyRequirementNoteById(String technologyRequirementId, String note) {
        TechnologyRequirement technologyRequirement=new TechnologyRequirement();
        technologyRequirement.setTechnologyRequirementId(technologyRequirementId);
        technologyRequirement.setNote(note);
        int i = technologyRequirementMapper.updateByPrimaryKeySelective(technologyRequirement);
        return i == 1;
    }

    @Override
    public ResponseOV<TechnologyRequirement> searchTechnologyRequirementByCondition(int flag, String searchValue, int page, int rows) {
        TechnologyRequirementExample technologyRequirement = new TechnologyRequirementExample();
        PageHelper.startPage(page, rows);
        if (flag == 1) {
            technologyRequirement.createCriteria().andTechnologyRequirementIdLike("%" + searchValue + "%");
        } else {
            technologyRequirement.createCriteria().andTechnologyRequirementNameLike("%" + searchValue + "%");
        }
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.selectByExample(technologyRequirement);
        PageInfo<TechnologyRequirement> info = new PageInfo<>(technologyRequirements);

        ResponseOV<TechnologyRequirement> ov = new ResponseOV<>();
        ov.setRows(technologyRequirements);
        ov.setTotal((int) info.getTotal());
        return ov;
    }
}
