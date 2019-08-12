package com.team.service;

import com.team.bean.Material;
import com.team.bean.MaterialConsume;
import com.team.bean.ResponseOV;

public interface MaterialConsumeService {
    ResponseOV<MaterialConsume> getMaterialConsume(int page, int rows);
    boolean insert(MaterialConsume record);
    boolean deleteByPrimaryKey(String consumeId);
    boolean updateByPrimaryKey(MaterialConsume record);
    ResponseOV<MaterialConsume> searchMaterialConsumeByCondition(int flag, String searchValue, int page, int rows);
}
