package com.team.service;

import com.team.bean.MaterialReceive;
import com.team.bean.MaterialReceiveExample;

import java.util.List;

public interface MaterialReceiveService {
    long countByExample(MaterialReceiveExample example);

    List<MaterialReceive> selectByExample(MaterialReceiveExample example);
}
