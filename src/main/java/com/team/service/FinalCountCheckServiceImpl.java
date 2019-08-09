package com.team.service;

import com.github.pagehelper.PageHelper;
import com.team.bean.FinalCountCheck;
import com.team.mapper.FinalCountCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalCountCheckServiceImpl implements FinalCountCheckService {
    @Autowired
    private FinalCountCheckMapper finalCountCheckMapper;

    @Override
    public List<FinalCountCheck> getPageFinalCountCheck(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.getPageFinalCountCheck();
        return finalCountChecks;
    }
}
