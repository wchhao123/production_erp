package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import com.team.bean.COrder;
import com.team.bean.COrderExample;
import com.team.bean.ResponseOV;
import com.team.mapper.COrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private COrderMapper orderMapper;

    @Override
    public ResponseOV<COrder> getPageCOrder(int index, int pageSize) {
        ResponseOV<COrder> orderResponse = new ResponseOV<>();
        long l = orderMapper.countByExample(null);
        List<COrder> pageCOrder = orderMapper.getPageCOrder((index - 1) * pageSize, pageSize);
        orderResponse.setTotal((int) l);
        orderResponse.setRows(pageCOrder);
        return orderResponse;
    }

    @Override
    public boolean updateOrder(COrder order) {
        int i = orderMapper.updateByPrimaryKeySelective(order);
        return i == 1;
    }

    @Override
    public boolean deleteByIds(String[] ids) {
        int i = orderMapper.batchDeleteByIds(ids);
        return i != 0;
    }

    @Override
    public boolean insertOrder(COrder order) {
        int insert = orderMapper.insert(order);
        return insert == 1;
    }

    @Override
    public ResponseOV<COrder> searchOrderByCondition(int flag, String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<COrder> cOrders = orderMapper.searchOrderByCondition(flag, "%" + searchValue + "%");
        PageInfo<COrder> info = new PageInfo<>(cOrders);

        ResponseOV<COrder> ov = new ResponseOV<>();
        ov.setTotal((int) info.getTotal());
        ov.setRows(cOrders);
        return ov;
    }


}
