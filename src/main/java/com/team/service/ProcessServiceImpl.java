package com.team.service;

import com.team.bean.COrder;
import com.team.bean.Process;
import com.team.bean.ResponseOV;
import com.team.mapper.ProcessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessMapper processMapper;


    @Override
    public ResponseOV<Process> getPageProcess(int index, int pageSize) {
        ResponseOV<Process> processResponse = new ResponseOV<>();
        long l = processMapper.countByExample(null);
        List<Process> pageProcess=processMapper.getPageProcess((index-1)*pageSize,pageSize);
        processResponse.setTotal((int) l);
        processResponse.setRows(pageProcess);
        return processResponse;
    }

    @Override
    public boolean insertProcess(Process process) {
        return processMapper.insert(process) == 1;
    }

    @Override
    public boolean deleteByIds(String[] ids) {
        return processMapper.batchDeleteByIds(ids) != 0;
    }

    @Override
    public Process getProcessById(String id) {
        return processMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Process> getProcessList() {
        return processMapper.selectByExample(null);
    }
}
