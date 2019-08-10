package com.team.service;

import com.team.bean.FinalMeasuretCheck;
import com.team.bean.ResponseOV;

public interface FinalMeasureCheckService {
    ResponseOV<FinalMeasuretCheck> getPageFinalMeasureCheck(int page, int rows);

    boolean insertFinalMeasuretCheck(FinalMeasuretCheck finalMeasuretCheck);

    boolean updateFinalMeasuretCheck(FinalMeasuretCheck finalMeasuretCheck);

    boolean deleteByIds(String[] ids);

    ResponseOV<FinalMeasuretCheck> searchFinalMeasureCheckByCondition(int flag, String searchValue, int page, int rows);
}
