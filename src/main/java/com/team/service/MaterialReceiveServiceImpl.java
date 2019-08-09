package com.team.service;

import com.team.bean.MaterialReceive;
import com.team.bean.MaterialReceiveExample;
import com.team.mapper.MaterialReceiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class MaterialReceiveServiceImpl implements MaterialReceiveService {
    @Autowired
    MaterialReceiveMapper materialReceiveMapper;

    @Override
    public long countByExample(MaterialReceiveExample example) {
        return materialReceiveMapper.countByExample(example);
    }

    @Override
    public List<MaterialReceive> selectByExample(MaterialReceiveExample example) {
        return materialReceiveMapper.selectByExample(example);
    }
}
