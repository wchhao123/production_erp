package com.team.service;

import com.team.bean.ResponseOV;
import com.team.bean.UnqualifyApply;
import com.team.bean.UnqualifyApplyExample;
import com.team.mapper.UnqualifyApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnqualifyApplyServiceImpl implements UnqualifyApplyService {
    @Autowired
    private UnqualifyApplyMapper unqualifyApplyMapper;

    @Override
    public ResponseOV<UnqualifyApply> getPageUnqualifyApply(int page, int rows) {
        ResponseOV<UnqualifyApply> responseOV = new ResponseOV<>();
        UnqualifyApplyExample example = new UnqualifyApplyExample();
        long total = unqualifyApplyMapper.countByExample(example);
        responseOV.setTotal((int) total);

        List<UnqualifyApply> rowsList = unqualifyApplyMapper.getPageUnqualifyApply((page - 1) * rows, rows);
        responseOV.setRows(rowsList);
        return responseOV;
    }

    @Override
    public boolean insertUnqualifyApply(UnqualifyApply unqualifyApply) {
       int insert = unqualifyApplyMapper.insert(unqualifyApply);
        return insert == 1;
    }

    @Override
    public boolean deleteByIds(String[] ids) {
        int i = unqualifyApplyMapper.batchDeleteByIds(ids);
        return i != 0;
    }
}
