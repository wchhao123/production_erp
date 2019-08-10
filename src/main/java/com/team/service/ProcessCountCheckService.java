package com.team.service;

import com.team.bean.ProcessCountCheck;
import com.team.bean.ResponseOV;

import java.util.List;

public interface ProcessCountCheckService {
    List<ProcessCountCheck> getPageProcessCountCheck(int page, int rows);

    boolean insertProcessCountCheck(ProcessCountCheck processCountCheck);

    boolean updateProcessCountCheck(ProcessCountCheck processCountCheck);

    boolean deleteByIds(String[] ids);

    ResponseOV<ProcessCountCheck> searchProcessCountCheckByCondition(String searchValue, int page, int rows);
}
