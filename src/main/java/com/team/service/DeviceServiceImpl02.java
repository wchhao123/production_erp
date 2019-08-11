package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.*;
import com.team.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl02 implements IDeviceService02 {
    @Autowired
    private DeviceTypeMapper deviceTypeMapper;

    //2.设备种类
    //2.1 查
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
    //2.1 增
    @Override
    public boolean deviceTypeInsert(DeviceType deviceType) {
        return deviceTypeMapper.insert(deviceType)==1;
    }
    //2.2 改
    @Override
    public boolean deviceTypeEdit(DeviceType deviceType) {
        return deviceTypeMapper.updateByPrimaryKey(deviceType)==1;
    }



    //2.3 删
    @Override
    public boolean delete_batch(String ids) {
        return deviceTypeMapper.deleteByPrimaryKey(ids)==1;
    }

    //2.4 模糊查询
    @Override
    public ResponseOV<DeviceType> search_deviceType_by_condition(int flag, String condition, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceType> deviceTypes = deviceTypeMapper.search_deviceType_by_condition(flag,condition);

        ResponseOV<DeviceType> responseOV = new ResponseOV<>();
        long total = new PageInfo<>(deviceTypes).getTotal();
        responseOV.setTotal((int) total);
        responseOV.setRows(deviceTypes);
        System.out.println(responseOV);
        return responseOV;
    }

}
