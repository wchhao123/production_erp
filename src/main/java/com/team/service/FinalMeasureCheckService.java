package com.team.service;

import com.team.bean.FinalMeasuretCheck;
import com.team.bean.ResponseOV;

public interface FinalMeasureCheckService {
    ResponseOV<FinalMeasuretCheck> getPageFinalMeasureCheck(int page, int rows);
}
