package com.team.service;

import com.team.bean.*;

import java.util.List;

public interface IDeviceService {
    ResponseOV<Device> getPageDevice(int index, int pageSize);


    List<DeviceType> getDeviceTypeList();

    boolean insertDevice(Device device);

    boolean update(Device device);

    List<Device> getDevice();

    boolean delete_batch(String[] ids);

    ResponseOV<Device> search_device_by_condition(int flag, String condition, int page, int rows);

    Device getDeviceById(String id);
}
