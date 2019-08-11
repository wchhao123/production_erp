package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.*;
import com.team.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl03 implements IDeviceService03 {

    //3.设备检修
    @Autowired
    private DeviceCheckMapper deviceCheckMapper;

    @Override
    public ResponseOV<DeviceCheck> findDeviceCheckList(int page, int rows){
        PageHelper.startPage(page,rows);
        ResponseOV<DeviceCheck> responseOV=new ResponseOV<>();
        List<DeviceCheck> deviceCheckList = deviceCheckMapper.findDeviceCheckList(page, rows);
        long total = new PageInfo<>(deviceCheckList).getTotal();
        responseOV.setTotal((int) total);
        responseOV.setRows(deviceCheckList);
        return responseOV;
    }

    @Override
    public boolean deviceCheckInsert(DeviceCheck deviceCheck) {
        return deviceCheckMapper.insert(deviceCheck)==1;
    }

    @Override
    public boolean deviceCheckEdit(DeviceCheck deviceCheck) {
        return deviceCheckMapper.updateByPrimaryKey(deviceCheck)==1;
    }

    @Override
    public boolean delete_batch(String ids) {
        return deviceCheckMapper.deleteByPrimaryKey(ids)==1;
    }

    @Override
    public ResponseOV<DeviceCheck> search_deviceCheck_by_condition(int flag, String condition, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceCheck> deviceChecks = deviceCheckMapper.search_deviceCheck_by_condition(flag,condition);

        ResponseOV<DeviceCheck> responseOV = new ResponseOV<>();
        long total = new PageInfo<>(deviceChecks).getTotal();
        responseOV.setTotal((int) total);
        responseOV.setRows(deviceChecks);
        System.out.println(responseOV);
        return responseOV;
    }
}
