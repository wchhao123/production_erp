package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.FinalMeasuretCheck;
import com.team.bean.FinalMeasuretCheckExample;
import com.team.bean.ResponseOV;
import com.team.mapper.FinalMeasuretCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FinalMeasureCheckServiceImpl implements FinalMeasureCheckService {
    @Autowired
    private FinalMeasuretCheckMapper finalMeasuretCheckMapper;

    @Override
    public ResponseOV<FinalMeasuretCheck> getPageFinalMeasureCheck(int page, int rows) {
        ResponseOV<FinalMeasuretCheck> responseOV = new ResponseOV<>();
        FinalMeasuretCheckExample example = new FinalMeasuretCheckExample();
        long l = finalMeasuretCheckMapper.countByExample(example);
        responseOV.setTotal((int) l);
        List<FinalMeasuretCheck> rowsList = finalMeasuretCheckMapper.getFinalMeasureCheck((page - 1) * rows, rows);
        responseOV.setRows(rowsList);
        return responseOV;
    }

    @Override
    public boolean insertFinalMeasuretCheck(FinalMeasuretCheck finalMeasuretCheck) {
        int i = finalMeasuretCheckMapper.insertSelective(finalMeasuretCheck);
        return i == 1;
    }

    @Override
    public boolean updateFinalMeasuretCheck(FinalMeasuretCheck finalMeasuretCheck) {
        //updateAll和uptateNote共用此方法，因此使用带Selective的
        int update = finalMeasuretCheckMapper.updateByPrimaryKeySelective(finalMeasuretCheck);
        return update == 1;
    }

    @Override
    public boolean deleteByIds(String[] ids) {
        FinalMeasuretCheckExample example = new FinalMeasuretCheckExample();
        example.createCriteria().andFMeasureCheckIdIn(new ArrayList<>(Arrays.asList(ids)));
        int i = finalMeasuretCheckMapper.deleteByExample(example);
        return i != 0;
    }

    @Override
    public ResponseOV<FinalMeasuretCheck> searchFinalMeasureCheckByCondition(int flag, String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<FinalMeasuretCheck> finalMeasureChecks = finalMeasuretCheckMapper.searchFinalMeasureCheckByCondition(flag, "%" + searchValue + "%");
        PageInfo<FinalMeasuretCheck> pageInfo = new PageInfo<>(finalMeasureChecks);

        ResponseOV<FinalMeasuretCheck> responseOV = new ResponseOV<>();
        responseOV.setRows(finalMeasureChecks);
        responseOV.setTotal((int) pageInfo.getTotal());
        return responseOV;
    }
}
