package com.team.service;

import com.team.bean.ProcessMeasureCheck;

import java.util.List;

public interface ProcessMeasureCheckService {
    List<ProcessMeasureCheck> getPageProcessMeasureCheck(int page, int rows);
}
