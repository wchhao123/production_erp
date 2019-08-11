package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.FinalCountCheck;
import com.team.bean.FinalCountCheckExample;
import com.team.bean.ResponseOV;
import com.team.mapper.FinalCountCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public boolean insertFinalCountCheck(FinalCountCheck finalCountCheck) {
        int insert = finalCountCheckMapper.insert(finalCountCheck);
        return insert == 1;
    }

    @Override
    public boolean updateFinalCountCheck(FinalCountCheck finalCountCheck) {
        int update = finalCountCheckMapper.updateByPrimaryKeySelective(finalCountCheck);
        return update == 1;
    }

    @Override
    public boolean deleteByIds(String[] ids) {
        FinalCountCheckExample example = new FinalCountCheckExample();
        example.createCriteria().andFCountCheckIdIn(new ArrayList<>(Arrays.asList(ids)));
        int i = finalCountCheckMapper.deleteByExample(example);
        return i != 0;
    }

    @Override
    public ResponseOV<FinalCountCheck> searchFinalCountCheckByCondition(int flag, String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectFinalCountCheckByCondition(flag, "%" + searchValue + "%");
        PageInfo<FinalCountCheck> pageInfo = new PageInfo<>(finalCountChecks);

        ResponseOV<FinalCountCheck> responseOV = new ResponseOV<>();
        responseOV.setRows(finalCountChecks);
        responseOV.setTotal((int) pageInfo.getTotal());
        return responseOV;
    }
}
