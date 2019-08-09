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

    @Override
    public ResponseOV<COrder> getPageCOrder(int index, int pageSize) {
        ResponseOV<COrder> orderResponse = new ResponseOV<>();
        long l = orderMapper.countByExample(null);
        List<COrder> pageCOrder = orderMapper.getPageCOrder((index - 1) * pageSize, pageSize);
        orderResponse.setTotal((int) l);
        orderResponse.setRows(pageCOrder);
        return orderResponse;
    }

}