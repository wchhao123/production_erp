package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.ProcessMeasureCheck;
import com.team.bean.ProcessMeasureCheckExample;
import com.team.bean.ResponseOV;
import com.team.mapper.ProcessMeasureCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public boolean insertProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck) {
        int insert = processMeasureCheckMapper.insert(processMeasureCheck);
        return insert == 1;
    }

    @Override
    public boolean updateProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck) {
        int update = processMeasureCheckMapper.updateByPrimaryKeySelective(processMeasureCheck);
        return update == 1;
    }

    @Override
    public boolean deleteByIds(String[] ids) {
        ProcessMeasureCheckExample example = new ProcessMeasureCheckExample();
        example.createCriteria().andPMeasureCheckIdIn(new ArrayList<>(Arrays.asList(ids)));
        int i = processMeasureCheckMapper.deleteByExample(example);
        return i != 0;
    }

    @Override
    public ResponseOV<ProcessMeasureCheck> searchProcessMeasureCheckByCondition(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckMapper.searchProcessMeasureCheckByCondition("%" + searchValue + "%");
        PageInfo<ProcessMeasureCheck> pageInfo = new PageInfo<>(processMeasureChecks);

        ResponseOV<ProcessMeasureCheck> responseOV = new ResponseOV<>();
        responseOV.setTotal((int) pageInfo.getTotal());
        responseOV.setRows(processMeasureChecks);
        return responseOV;
    }
}
