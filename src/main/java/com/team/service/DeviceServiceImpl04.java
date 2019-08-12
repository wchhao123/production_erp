package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.Device;
import com.team.bean.DeviceFault;
import com.team.bean.ResponseOV;
import com.team.mapper.DeviceFaultMapper;
import com.team.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl04 implements IDeviceService04 {

    //3.设备检修
    @Autowired
    private DeviceFaultMapper deviceFaultMapper;

    @Override
    public ResponseOV<DeviceFault> findDeviceFaultList(int page, int rows){
        PageHelper.startPage(page,rows);
        ResponseOV<DeviceFault> responseOV=new ResponseOV<>();
        List<DeviceFault> deviceFaultList = deviceFaultMapper.findDeviceFaultList(page, rows);
        long total = new PageInfo<>(deviceFaultList).getTotal();
        responseOV.setTotal((int) total);
        responseOV.setRows(deviceFaultList);
        return responseOV;
    }

    @Override
    public boolean deviceFaultInsert(DeviceFault deviceFault) {
        return deviceFaultMapper.insert(deviceFault)==1;
    }

    @Override
    public boolean deviceFaultEdit(DeviceFault deviceFault) {
        return deviceFaultMapper.updateByPrimaryKey(deviceFault)==1;
    }

    @Override
    public boolean delete_batch(String[] ids) {
        boolean flag=true;
        for (String id : ids) {
            if (deviceFaultMapper.deleteByPrimaryKey(id)!=1) {
                flag=false;
                break;
            }
        }
        return flag;
    }

    @Override
    public ResponseOV<DeviceFault> search_deviceFault_by_condition(int flag, String condition, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceFault> deviceFaults = deviceFaultMapper.search_deviceFault_by_condition(flag,condition);

        ResponseOV<DeviceFault> responseOV = new ResponseOV<>();
        long total = new PageInfo<>(deviceFaults).getTotal();
        responseOV.setTotal((int) total);
        responseOV.setRows(deviceFaults);
        System.out.println(responseOV);
        return responseOV;
    }
    @Autowired
    private DeviceMapper deviceMapper;
    @Override
    public List<Device> getDeviceList() {
        return deviceMapper.selectByExample(null);
    }

    @Override
    public DeviceFault deviceFault(String id) {
        return deviceFaultMapper.selectByPrimaryKey(id);
    }
}
