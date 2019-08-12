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

    @Override
    public boolean deleteByPrimaryKey(String receiveId) {
        int i = materialReceiveMapper.deleteByPrimaryKey(receiveId);
        return i != 0;
    }

    @Override
    public boolean insert(MaterialReceive record) {
        int insert = materialReceiveMapper.insert(record);
        return insert == 1;
    }

    @Override
    public boolean updateByPrimaryKeySelective(MaterialReceive record) {
        int update = materialReceiveMapper.updateByPrimaryKey(record);
        return update ==1;
    }

    @Override
    public ResponseOV<MaterialReceive> searchMaterialReceiveByCondition(int flag, String searchValue, int page, int rows) {
        PageHelper.startPage(page , rows);
        List<MaterialReceive> materialReceives = materialReceiveMapper.searchMaterialByCondition(flag, "%"+searchValue+"%");
        PageInfo<MaterialReceive> info = new PageInfo<>(materialReceives);
        ResponseOV<MaterialReceive> ov = new ResponseOV<>();
        ov.setRows(materialReceives);
        ov.setTotal((int) info.getTotal());
        return ov;

    }


}



