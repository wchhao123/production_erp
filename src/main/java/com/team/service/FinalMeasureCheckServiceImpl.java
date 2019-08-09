package com.team.service;

import com.team.bean.FinalMeasuretCheck;
import com.team.bean.FinalMeasuretCheckExample;
import com.team.bean.ResponseOV;
import com.team.mapper.FinalMeasuretCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
