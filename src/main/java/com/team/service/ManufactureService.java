package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.Manufacture;
import com.team.bean.ManufactureExample;
import com.team.bean.ResponseOV;
import com.team.mapper.ManufactureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ManufactureService implements IManufactureService {

    @Autowired
    private ManufactureMapper mapper;

    @Override
    public ResponseOV<Manufacture> getManufacture(int page, int rows) {
        return searchManufactureByCondition(0, null, page, rows);
    }

    @Override
    public List<Manufacture> selectByExample() {
        return mapper.selectByExample(null);
    }

    @Override
    public boolean updateManufacture(Manufacture manufacture) {
        return mapper.updateByPrimaryKey(manufacture) == 1;
    }

    @Override
    public boolean deleteManufacturesByIds(String[] ids) {
        ManufactureExample example = new ManufactureExample();
        example.createCriteria().andOrderIdIn(new ArrayList<>(Arrays.asList(ids)));
        return mapper.deleteByExample(example) != 0;
    }

    @Override
    public boolean insertManufacture(Manufacture manufacture) {
        return mapper.insert(manufacture) == 1;
    }

    @Override
    public ResponseOV<Manufacture> searchManufactureByCondition(int flag, String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Manufacture> manufactures = mapper.selectManufactureByCondition(flag, "%" + searchValue + "%");
        PageInfo<Manufacture> info = new PageInfo<>(manufactures);

        ResponseOV<Manufacture> ov = new ResponseOV<>();
        ov.setRows(manufactures);
        ov.setTotal((int) info.getTotal());
        return ov;
    }
}
