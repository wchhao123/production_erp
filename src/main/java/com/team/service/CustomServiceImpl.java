package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.Custom;
import com.team.bean.ResponseOV;
import com.team.mapper.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomServiceImpl implements ICustomService {

    @Autowired
    private CustomMapper customMapper;

    @Override
    public Custom getCustomById(String id) {
        return customMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResponseOV<Custom> getCustoms(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Custom> customs = customMapper.selectByExample(null);
        PageInfo<Custom> pageInfo = new PageInfo<>(customs);
        long total = pageInfo.getTotal();

        ResponseOV<Custom> ov = new ResponseOV<>();
        ov.setTotal((int) total);
        ov.setRows(customs);
        return ov;
    }
}
