package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.*;
import com.team.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements IDeviceService {
    @Autowired
    private DeviceMapper deviceMapper;
    @Override
    public ResponseOV<Device> getPageDevice(int index, int pageSize) {
        ResponseOV<Device> deviceResponseOV = new ResponseOV<>();
        long l = deviceMapper.countByExample(null);
        List<Device> pageCOrder = deviceMapper.selectDeviceList((index - 1) * pageSize, pageSize);
        deviceResponseOV.setTotal((int) l);
        deviceResponseOV.setRows(pageCOrder);
        return deviceResponseOV;
    }
    //2.设备种类
    @Autowired
    private DeviceTypeMapper deviceTypeMapper;
    @Override
    public ResponseOV<DeviceType> getPageDeviceType(int page, int rows) {//page第几页，rows多少条
        PageHelper.startPage(page,rows);
        ResponseOV<DeviceType> deviceResponseOV = new ResponseOV<>();
        List<DeviceType> deviceTypes = deviceTypeMapper.selectByExample(null);
        long total = new PageInfo<>(deviceTypes).getTotal();
        deviceResponseOV.setTotal((int) total);
        deviceResponseOV.setRows(deviceTypes);
        return deviceResponseOV;
    }
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
    //4.设备故障
    @Autowired
    private DeviceFaultMapper deviceFaultMapper;
    @Override
    public ResponseOV<DeviceFault> findDeviceFaultList(int page, int rows){
        PageHelper.startPage(page,rows);
        ResponseOV<DeviceFault> responseOV=new ResponseOV<>();
        List<DeviceFault> DeviceFaultList = deviceFaultMapper.findDeviceFaultList(page, rows);
        long total = new PageInfo<>(DeviceFaultList).getTotal();
        responseOV.setTotal((int) total);
        responseOV.setRows(DeviceFaultList);
        return responseOV;
    }
    //5.设备维修
    @Autowired
    private DeviceMaintainMapper deviceMaintainMapper;
    @Override
    public ResponseOV<DeviceMaintain> findDeviceMaintainList(int page, int rows) {
        PageHelper.startPage(page,rows);
        ResponseOV<DeviceMaintain> responseOV=new ResponseOV<>();
        List<DeviceMaintain> DeviceMaintainList = deviceMaintainMapper.findDeviceMaintainList(page, rows);
        long total = new PageInfo<>(DeviceMaintainList).getTotal();
        responseOV.setTotal((int) total);
        responseOV.setRows(DeviceMaintainList);
        return responseOV;
    }

    @Override
    public List<Device> getDevice() {
        return deviceMapper.selectByExample(null);
    }

    @Override
    public Device getDeviceById(String id) {
        return deviceMapper.selectByPrimaryKey(id);
    }
}
