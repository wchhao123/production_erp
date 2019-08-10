package com.team.service;

import com.team.bean.Work;
import com.team.bean.WorkExample;

import java.util.List;

public interface WorkService {
    List<Work> selectByExample();
}
