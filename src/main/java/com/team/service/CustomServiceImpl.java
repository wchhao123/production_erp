package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.Custom;
import com.team.bean.CustomExample;
import com.team.bean.Product;
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

    @Override
    public List<Custom> getCustoms() {
        return customMapper.selectByExample(null);
    }

    @Override
    public boolean updateCustom(Custom custom) {
        int i = customMapper.updateByPrimaryKey(custom);
        return i == 1;
    }

    @Override
    public boolean deleteByIds(String[] ids) {
        int i = customMapper.deleteByIds(ids);
        return i == ids.length;
    }

    @Override
    public boolean insertCustom(Custom custom) {
        int insert = customMapper.insert(custom);
        return insert == 1;
    }

    @Override
    public ResponseOV<Custom> searchCustomByCondition(int flag, String searchValue, int page, int rows) {
        CustomExample example = new CustomExample();
        PageHelper.startPage(page, rows);
        if (flag == 1) {
            example.createCriteria().andCustomIdLike("%" + searchValue + "%");
        } else {
            example.createCriteria().andCustomNameLike("%" + searchValue + "%");
        }
        List<Custom> customs = customMapper.selectByExample(example);
        PageInfo<Custom> info = new PageInfo<>(customs);

        ResponseOV<Custom> ov = new ResponseOV<>();
        ov.setRows(customs);
        ov.setTotal((int) info.getTotal());
        return ov;
    }


}
