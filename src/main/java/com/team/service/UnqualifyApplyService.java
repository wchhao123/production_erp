package com.team.service;

import com.team.bean.ResponseOV;
import com.team.bean.UnqualifyApply;

public interface UnqualifyApplyService {
    //获取不合格品分页数据
    ResponseOV<UnqualifyApply> getPageUnqualifyApply(int page, int rows);
}
