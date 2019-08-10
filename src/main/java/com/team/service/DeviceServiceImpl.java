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
    //1.设备台账
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

    @Autowired
    private DeviceTypeMapper deviceTypeMapper;
    @Override
    public List<DeviceType> getDeviceTypeList() {
        return deviceTypeMapper.selectByExample(null);
    }

    /*@Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> getEmployeeList() {
        return employeeMapper.selectByExample(null);
    }*/

    @Override
    public boolean insertDevice(Device device) {
        int i = deviceMapper.insert(device);
        return i==1;
    }

    @Override
    public boolean update(Device device) {
        int i = deviceMapper.updateByPrimaryKeySelective(device);
        return i==1;
    }

    @Override
    public boolean delete_batch(String ids) {
        int i = deviceMapper.deleteByPrimaryKey(ids);
        return i==1;
    }

    @Override
    public ResponseOV<Device> search_device_by_condition(int flag, String condition, int page, int rows) {
        PageHelper.startPage(page,rows);

        ResponseOV<Device> responseOV = new ResponseOV<>();

        List<Device> devices = deviceMapper.search_device_by_condition(flag,condition);

        long total = new PageInfo<>(devices).getTotal();
        responseOV.setTotal((int) total);
        responseOV.setRows(devices);
        return responseOV;
    }

}
