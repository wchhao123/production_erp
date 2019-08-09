package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.MaterialConsume;
import com.team.bean.ResponseOV;
import com.team.mapper.MaterialConsumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {
    
    @Autowired
    MaterialConsumeMapper materialConsumeMapper;
    @Override
    public ResponseOV<MaterialConsume> getMaterialConsume(int page, int rows) {
        PageHelper.startPage(page  ,  rows);
        List<MaterialConsume> MaterialConsumes = materialConsumeMapper.queryMaterialConsume();
        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(MaterialConsumes);
        long total = pageInfo.getTotal();
        ResponseOV<MaterialConsume> ov = new ResponseOV<>();
        ov.setTotal((int) total);
        ov.setRows(MaterialConsumes);
        return ov;
    }

}
