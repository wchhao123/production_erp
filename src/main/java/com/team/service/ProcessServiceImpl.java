package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.*;
import com.team.bean.Process;
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
    public boolean updateProcess(Process process) {
        int i = processMapper.updateByPrimaryKey(process);
        return i == 1;
    }
    @Override
    public List<Process> getProcesses() {
        return processMapper.selectByExample(null);
    }
    @Override
    public boolean updateProcessNoteById(String processId, String note) {
        Process process=new Process();
        process.setProcessId(processId);
        process.setNote(note);
        int i = processMapper.updateByPrimaryKeySelective(process);
        return i == 1;
    }

    @Override
    public ResponseOV<Process> searchProcessByCondition(int flag, String searchValue, int page, int rows) {
        ProcessExample process = new ProcessExample();
        PageHelper.startPage(page, rows);
        if (flag == 1) {
            process.createCriteria().andProcessIdLike("%" + searchValue + "%");
        } else {
            process.createCriteria().andProcessNameLike("%" + searchValue + "%");
        }
        List<Process> processes = processMapper.selectByExample(process);
        PageInfo<Process> info = new PageInfo<>(processes);

        ResponseOV<Process> ov = new ResponseOV<>();
        ov.setRows(processes);
        ov.setTotal((int) info.getTotal());
        return ov;
    }
}
