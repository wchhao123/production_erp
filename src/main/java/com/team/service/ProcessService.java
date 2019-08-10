package com.team.service;

import com.team.bean.Process;
import com.team.bean.ResponseOV;

public interface ProcessService {
    ResponseOV<Process> getPageProcess(int index, int pageSize);

    int insertProcess(Process process);
}
