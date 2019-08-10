package com.team.service;

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
//        List<COrder> pageCOrder = orderMapper.getPageCOrder((index - 1) * pageSize, pageSize);
//        orderResponse.setTotal((int) l);
//        orderResponse.setRows(pageCOrder);
//        return orderResponse;
    }
}
