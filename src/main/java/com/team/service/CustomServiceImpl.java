package com.team.service;

import com.team.bean.Custom;
import com.team.mapper.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomServiceImpl implements ICustomService {

    @Autowired
    private CustomMapper customMapper;

    @Override
    public Custom getCustomById(String id) {
        return customMapper.selectByPrimaryKey(id);
    }
}
