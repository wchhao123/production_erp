package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.ResponseOV;
import com.team.bean.Work;
import com.team.mapper.WorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements IWorkService {

    @Autowired
    private WorkMapper workMapper;

    @Override
    public ResponseOV<Work> getWorks(int page, int rows) {

        return searchWorkByCondition(0, null, page, rows);
    }

    @Override
    public boolean updateWork(Work work) {
        return workMapper.updateByPrimaryKey(work) == 1;
    }


    @Override
    public boolean deleteWorksByIds(String[] ids) {
        return workMapper.batchDeleteWorkByIds(ids) != 0;
    }

    @Override
    public boolean insertWork(Work work) {
        return workMapper.insert(work) == 1;
    }

    @Override
    public ResponseOV<Work> searchWorkByCondition(int flag, String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Work> works = workMapper.selectWorkByCondition(flag, searchValue);
        PageInfo<Work> info = new PageInfo<>(works);

        ResponseOV<Work> ov = new ResponseOV<>();
        ov.setRows(works);
        ov.setTotal((int) info.getTotal());
        return ov;
    }
}
