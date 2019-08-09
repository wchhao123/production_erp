package com.team.service;

import com.team.bean.FinalCountCheck;

import java.util.List;

public interface FinalCountCheckService {
    List<FinalCountCheck> getPageFinalCountCheck(int page, int rows);
}
