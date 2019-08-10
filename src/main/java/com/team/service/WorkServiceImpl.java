package com.team.service;

import com.team.bean.Work;
import com.team.mapper.WorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkMapper workMapper;
    @Override
    public List<Work> selectByExample() {
        return workMapper.selectByExample(null);
    }
}
