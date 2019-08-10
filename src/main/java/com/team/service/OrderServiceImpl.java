package com.team.service;

import com.team.bean.COrder;
import com.team.bean.ResponseOV;
import com.team.mapper.COrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return false;
    }

    @Override
    public ResponseOV<COrder> searchOrderByCondition(int flag, String searchValue, int page, int rows) {
        return null;
    }

    @Override
    public boolean updateNoteById(String orderId, String note) {
        COrder order = new COrder();
        order.setOrderId(orderId);
        order.setNote(note);
        int i = orderMapper.updateByPrimaryKeySelective(order);
        return i == 1;
    }

}
