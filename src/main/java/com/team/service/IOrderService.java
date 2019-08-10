package com.team.service;


import com.team.bean.COrder;
import com.team.bean.ResponseOV;

import java.util.List;

public interface IOrderService {

    //获取一个页面的COrder
    ResponseOV<COrder> getPageCOrder(int index, int pageSize);

    boolean updateOrder(COrder order);

    boolean deleteByIds(String[] ids);

    boolean insertOrder(COrder order);

    //条件查询
    ResponseOV<COrder> searchOrderByCondition(int flag, String searchValue, int page, int rows);

    boolean updateNoteById(String orderId, String note);

    List<COrder> getOrdersData();
}
