package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.*;
import com.team.mapper.TechnologyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    private TechnologyMapper technologyMapper;

    @Override
    public Technology getTechnologyById(String id) {
        return technologyMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResponseOV<Technology> getTechnologies(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Technology> technologies = technologyMapper.selectByExample(null);
        PageInfo<Technology> pageInfo = new PageInfo<>(technologies);
        long total = pageInfo.getTotal();

        ResponseOV<Technology> ov = new ResponseOV<>();
        ov.setTotal((int) total);
        ov.setRows(technologies);
        return ov;
    }

    @Override
    public List<Technology> getTechnologies() {
        return technologyMapper.selectByExample(null);
    }

    @Override
    public boolean insertTechnology(Technology technology) {
        return technologyMapper.insert(technology) == 1;
    }

    @Override
    public boolean deleteByIds(String[] ids) {
        return technologyMapper.batchDeleteByIds(ids) != 0;
    }

    @Override
    public boolean updateTechnology(Technology technology) {
        int i = technologyMapper.updateByPrimaryKey(technology);
        return i == 1;
    }

    @Override
    public boolean updateTechnologyNoteById(String technologyId, String note) {
        Technology technology=new Technology();
        technology.setTechnologyId(technologyId);
        technology.setNote(note);
        int i = technologyMapper.updateByPrimaryKeySelective(technology);
        return i == 1;
    }

    @Override
    public ResponseOV<Technology> searchTechnologyByCondition(int flag, String searchValue, int page, int rows) {
        TechnologyExample technology = new TechnologyExample();
        PageHelper.startPage(page, rows);
        if (flag == 1) {
            technology.createCriteria().andTechnologyIdLike("%" + searchValue + "%");
        } else {
            technology.createCriteria().andTechnologyNameLike("%" + searchValue + "%");
        }
        List<Technology> technologies = technologyMapper.selectByExample(technology);
        PageInfo<Technology> info = new PageInfo<>(technologies);

        ResponseOV<Technology> ov = new ResponseOV<>();
        ov.setRows(technologies);
        ov.setTotal((int) info.getTotal());
        return ov;
    }
}
