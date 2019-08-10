package com.team.service;

import com.team.bean.*;

import java.util.List;

public interface IDeviceService {
    ResponseOV<Device> getPageDevice(int index, int pageSize);

    ResponseOV<DeviceType> getPageDeviceType(int page, int rows);

    ResponseOV<DeviceCheck> findDeviceCheckList(int page, int rows);

    ResponseOV<DeviceFault> findDeviceFaultList(int page, int rows);

    ResponseOV<DeviceMaintain> findDeviceMaintainList(int page, int rows);



    List<DeviceType> getDeviceTypeList();

    List<Employee> getEmployeeList();

    boolean insertDevice(Device device);

    boolean update(Device device);

    boolean delete_batch(String ids);

    ResponseOV<Device> search_device_by_deviceName(String deviceName,int index, int pageSize);
}
