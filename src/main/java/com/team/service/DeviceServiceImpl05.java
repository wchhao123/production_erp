package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.Device;
import com.team.bean.DeviceFault;
import com.team.bean.DeviceMaintain;
import com.team.bean.ResponseOV;
import com.team.mapper.DeviceFaultMapper;
import com.team.mapper.DeviceMaintainMapper;
import com.team.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl05 implements IDeviceService05 {

    //设备检修
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
    public boolean delete_batch(String[] ids) {
        boolean flag=true;
        for (String id : ids) {
            if (deviceMaintainMapper.deleteByPrimaryKey(id)!=1) {
                flag=false;
                break;
            }
        }
        return flag;
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
