package com.team.service;

import com.team.bean.COrder;
import com.team.bean.Material;
import com.team.bean.MaterialExample;
import com.team.bean.ResponseOV;
import com.team.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class MaterialServiceImpl implements  MaterialService {
    @Autowired
    MaterialMapper materialMapper;
    @Override
    public long countByExample(MaterialExample example) {
        return materialMapper.countByExample(example);
    }

    @Override
    public List<Material> selectByExample() {

        return materialMapper.selectByExample(null);
    }

    @Override
    public ResponseOV<Material> getPageMaterial(int page, int rows) {
        ResponseOV<Material> materialResponseOV = new ResponseOV<>();
        long l = materialMapper.countByExample(null);
        List<Material> pageMaterial = materialMapper.getPageMaterial((page - 1) * rows, rows);
        materialResponseOV.setTotal((int) l);
        materialResponseOV.setRows(pageMaterial);
        return materialResponseOV;
    }

    @Override
    public Material selectByPrimaryKey(String materialId) {
        return materialMapper.selectByPrimaryKey(materialId);
    }

    @Override
    public boolean insert(Material record) {
        int insert = materialMapper.insert(record);
        return insert ==1;
    }

    @Override
    public boolean deleteByPrimaryKey(String materialId) {
        int i = materialMapper.deleteByPrimaryKey(materialId);
        return i != 0;
    }

    @Override
    public boolean updateByPrimaryKey(Material record) {
        int update = materialMapper.updateByPrimaryKey(record);
        return update == 1;
    }
}
