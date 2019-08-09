package com.team.service;

import com.github.pagehelper.PageHelper;
import com.team.bean.ProcessCountCheck;
import com.team.mapper.ProcessCountCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService {
    @Autowired
    private ProcessCountCheckMapper processCountCheckMapper;
    @Override
    public List<ProcessCountCheck> getPageProcessCountCheck(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<ProcessCountCheck> processCountChecks = processCountCheckMapper.getPageProcessCountCheck();
        return processCountChecks;
    }
}
