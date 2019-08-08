package com.team.service;


import com.team.bean.COrder;
import com.team.bean.ResponseOV;

public interface IOrderService {

    ResponseOV<COrder> getPageCOrder(int index, int pageSize);
}
