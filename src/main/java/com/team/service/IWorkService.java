package com.team.service;

import com.team.bean.ResponseOV;
import com.team.bean.Work;

import java.util.List;

public interface IWorkService {
    ResponseOV<Work> getWorks(int page, int rows);

    boolean updateWork(Work work);

    boolean deleteWorksByIds(String[] ids);

    boolean insertWork(Work work);

    ResponseOV<Work> searchWorkByCondition(int flag, String searchValue, int page, int rows);

    List<Work> selectByExample();
}
