package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.COrder;
import com.team.bean.ResponseOV;
import com.team.mapper.COrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private COrderMapper orderMapper;

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
        return orderMapper.updateByPrimaryKey(order) == 1;
    }

    @Override
    public boolean deleteByIds(String[] ids) {
        return orderMapper.batchDeleteByIds(ids) != 0;
    }

    @Override
    public boolean insertOrder(COrder order) {
        return orderMapper.insert(order) == 1;
    }

    @Override
    public ResponseOV<COrder> searchOrderByCondition(int flag, String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<COrder> orders = orderMapper.searchOrderByCondition(flag, "%" + searchValue + "%");
        PageInfo<COrder> info = new PageInfo<>(orders);

        ResponseOV<COrder> ov = new ResponseOV<>();
        ov.setRows(orders);
        ov.setTotal((int) info.getTotal());
        return ov;
    }

    @Override
    public boolean updateNoteById(String orderId, String note) {
        COrder order = new COrder();
        order.setOrderId(orderId);
        order.setNote(note);
        int i = orderMapper.updateByPrimaryKeySelective(order);
        return i == 1;
    }

    @Override
    public List<COrder> getCOrders() {
        return orderMapper.selectByExample(null);
    }

    @Override
    public COrder getOrderById(String id) {
        return orderMapper.selectOrderById(id);
    }

}
