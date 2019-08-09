package com.team.service;

import com.team.bean.COrder;
import com.team.bean.Device;
import com.team.bean.DeviceType;
import com.team.bean.ResponseOV;
import com.team.mapper.DeviceMapper;
import com.team.mapper.DeviceTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements IDeviceService {
    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private DeviceTypeMapper deviceTypeMapper;
    @Override
    public ResponseOV<Device> getPageDevice(int index, int pageSize) {
        ResponseOV<Device> deviceResponseOV = new ResponseOV<>();
        long l = deviceMapper.countByExample(null);
        List<Device> pageCOrder = deviceMapper.selectDeviceList((index - 1) * pageSize, pageSize);
        deviceResponseOV.setTotal((int) l);
        deviceResponseOV.setRows(pageCOrder);
        return deviceResponseOV;
    }

    @Override
    public ResponseOV<DeviceType> getPageDeviceType(int page, int rows) {
        ResponseOV<DeviceType> deviceResponseOV = new ResponseOV<>();
        long l = deviceTypeMapper.countByExample(null);
//        List<DeviceType> pageDeviceType = deviceTypeMapper.selectDeviceTypeList((index - 1) * pageSize, pageSize);
        deviceResponseOV.setTotal((int) l);
//        deviceResponseOV.setRows(pageDeviceType);
        return deviceResponseOV;
    }
}
