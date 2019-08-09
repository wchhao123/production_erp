package com.team.service;


import com.team.bean.COrder;
import com.team.bean.ResponseOV;

public interface IOrderService {

    //获取一个页面的COrder
    ResponseOV<COrder> getPageCOrder(int index, int pageSize);
}
