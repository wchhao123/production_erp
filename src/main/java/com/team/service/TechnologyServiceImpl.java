package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.Custom;
import com.team.bean.ResponseOV;
import com.team.bean.Technology;
import com.team.mapper.TechnologyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements ITechnologyService{

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
}
