package com.team.service;

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

}
