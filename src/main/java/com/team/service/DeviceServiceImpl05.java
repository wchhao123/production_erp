package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.*;
import com.team.mapper.DeviceFaultMapper;
import com.team.mapper.DeviceMaintainMapper;
import com.team.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class DeviceServiceImpl05 implements IDeviceService05 {

    @Autowired
    private IDeviceService deviceService;
    //3.设备检修
    @Autowired
    private DeviceMaintainMapper deviceMaintainMapper;

    @Override
    public ResponseOV<DeviceMaintain> findDeviceMaintainList(int page, int rows){
        PageHelper.startPage(page,rows);
        ResponseOV<DeviceMaintain> responseOV=new ResponseOV<>();
        List<DeviceMaintain> deviceMaintainList = deviceMaintainMapper.findDeviceMaintainList(page, rows);
        long total = new PageInfo<>(deviceMaintainList).getTotal();
        responseOV.setTotal((int) total);
        responseOV.setRows(deviceMaintainList);
        return responseOV;
    }

    @Override
    public boolean deviceMaintainInsert(DeviceMaintain deviceMaintain) {
        return deviceMaintainMapper.insert(deviceMaintain)==1;
    }

    @Override
    public boolean deviceMaintainEdit(DeviceMaintain deviceMaintain) {
        return deviceMaintainMapper.updateByPrimaryKey(deviceMaintain)==1;
    }

    @Override
    public boolean delete_batch(String ids) {
        return deviceMaintainMapper.deleteByPrimaryKey(ids)==1;
    }

    @Override
    public ResponseOV<DeviceMaintain> search_deviceMaintain_by_condition(int flag, String condition, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceMaintain> deviceMaintains = deviceMaintainMapper.search_deviceMaintain_by_condition(flag,condition);

        ResponseOV<DeviceMaintain> responseOV = new ResponseOV<>();
        long total = new PageInfo<>(deviceMaintains).getTotal();
        responseOV.setTotal((int) total);
        responseOV.setRows(deviceMaintains);
        System.out.println(responseOV);
        return responseOV;
    }
    @Autowired
    private DeviceFaultMapper deviceFaultMapper;
    @Override
    public List<DeviceFault> getdeviceFault() {
        return deviceFaultMapper.selectByExample(null);
    }

}
