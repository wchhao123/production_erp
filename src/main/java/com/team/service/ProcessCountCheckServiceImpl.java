package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.ProcessCountCheck;
import com.team.bean.ProcessCountCheckExample;
import com.team.bean.ResponseOV;
import com.team.mapper.ProcessCountCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public boolean insertProcessCountCheck(ProcessCountCheck processCountCheck) {
        int i = processCountCheckMapper.insertSelective(processCountCheck);
        return i == 1;
    }

    @Override
    public boolean updateProcessCountCheck(ProcessCountCheck processCountCheck) {
        int update = processCountCheckMapper.updateByPrimaryKeySelective(processCountCheck);
        return update == 1;
    }

    @Override
    public boolean deleteByIds(String[] ids) {
        ProcessCountCheckExample example = new ProcessCountCheckExample();
        example.createCriteria().andPCountCheckIdIn(new ArrayList<>(Arrays.asList(ids)));
        int i = processCountCheckMapper.deleteByExample(example);
        return i != 0;
    }

    @Override
    public ResponseOV<ProcessCountCheck> searchProcessCountCheckByCondition(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<ProcessCountCheck> processCountChecks = processCountCheckMapper.searchProcessCountCheckByCondition("%" + searchValue + "%");
        PageInfo<ProcessCountCheck> pageInfo = new PageInfo<>(processCountChecks);

        ResponseOV<ProcessCountCheck> responseOV = new ResponseOV<>();
        responseOV.setRows(processCountChecks);
        responseOV.setTotal((int) pageInfo.getTotal());
        return responseOV;
    }
}
