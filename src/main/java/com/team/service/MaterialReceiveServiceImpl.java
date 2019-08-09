package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.Material;
import com.team.bean.MaterialReceive;
import com.team.bean.ResponseOV;
import com.team.mapper.MaterialReceiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {
    @Autowired
    MaterialReceiveMapper materialReceiveMapper;

    @Override
    public ResponseOV<MaterialReceive> getMaterialReceive(int page, int rows) {
        PageHelper.startPage(page  ,  rows);
        List<MaterialReceive> materialReceives = materialReceiveMapper.queryMaterialReceive();
        PageInfo<MaterialReceive> pageInfo = new PageInfo<>(materialReceives);
        long total = pageInfo.getTotal();
        ResponseOV<MaterialReceive> ov = new ResponseOV<>();
        ov.setTotal((int) total);
        ov.setRows(materialReceives);
        return ov;
    }


    }



