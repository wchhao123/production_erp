package com.team.service;

import com.team.bean.ProcessCountCheck;

import java.util.List;

public interface ProcessCountCheckService {
    List<ProcessCountCheck> getPageProcessCountCheck(int page, int rows);
}
