package com.team.service;

import com.team.bean.FinalCountCheck;
import com.team.bean.ResponseOV;

import java.util.List;

public interface FinalCountCheckService {
    List<FinalCountCheck> getPageFinalCountCheck(int page, int rows);

    boolean insertFinalCountCheck(FinalCountCheck finalCountCheck);

    boolean updateFinalCountCheck(FinalCountCheck finalCountCheck);

    boolean deleteByIds(String[] ids);

    ResponseOV<FinalCountCheck> searchFinalCountCheckByCondition(int flag, String searchValue, int page, int rows);
}
