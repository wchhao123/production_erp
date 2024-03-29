package com.team.service;

import com.team.bean.Process;
import com.team.bean.ResponseOV;

import java.util.List;

public interface ProcessService {
    ResponseOV<Process> getPageProcess(int index, int pageSize);

    boolean insertProcess(Process process);

    boolean deleteByIds(String[] ids);

    Process getProcessById(String id);

    boolean updateProcess(Process process);

    List<Process> getProcesses();

    boolean updateProcessNoteById(String processId, String note);

    ResponseOV<Process> searchProcessByCondition(int flag, String searchValue, int page, int rows);
}
