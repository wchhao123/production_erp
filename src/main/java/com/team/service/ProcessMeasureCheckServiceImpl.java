package com.team.service;

import com.github.pagehelper.PageHelper;
import com.team.bean.ProcessMeasureCheck;
import com.team.mapper.ProcessMeasureCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessMeasureCheckServiceImpl implements ProcessMeasureCheckService {
    @Autowired
    private ProcessMeasureCheckMapper processMeasureCheckMapper;
    @Override
    public List<ProcessMeasureCheck> getPageProcessMeasureCheck(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckMapper.getPageProcessMeasureCheck();
        return processMeasureChecks;
    }
}
