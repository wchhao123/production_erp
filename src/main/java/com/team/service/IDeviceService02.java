package com.team.service;

import com.team.bean.*;

import java.util.List;

public interface IDeviceService02 {
    ResponseOV<DeviceType> getPageDeviceType(int page, int rows);

    boolean deviceTypeInsert(DeviceType deviceType);

    boolean deviceTypeEdit(DeviceType deviceType);

    boolean delete_batch(String[] ids);

    ResponseOV<DeviceType> search_deviceType_by_condition(int flag, String condition, int page, int rows);

    DeviceType deviceType(String id);
}
