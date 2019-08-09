package com.team.service;

import com.team.bean.Material;
import com.team.bean.MaterialReceive;
import com.team.bean.MaterialReceiveExample;
import com.team.bean.ResponseOV;

import java.util.List;

public interface MaterialReceiveService {


    ResponseOV<MaterialReceive>getMaterialReceive(int page , int rows);


}
