package com.team.service;

import com.team.bean.ProcessMeasureCheck;
import com.team.bean.ResponseOV;

import java.util.List;

public interface ProcessMeasureCheckService {
    List<ProcessMeasureCheck> getPageProcessMeasureCheck(int page, int rows);

    boolean insertProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck);

    boolean updateProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck);

    boolean deleteByIds(String[] ids);

    ResponseOV<ProcessMeasureCheck> searchProcessMeasureCheckByCondition(String searchValue, int page, int rows);
}
