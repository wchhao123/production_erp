package com.team.service;

import com.team.bean.COrder;
import com.team.bean.Device;
import com.team.bean.DeviceType;
import com.team.bean.ResponseOV;

public interface IDeviceService {
    ResponseOV<Device> getPageDevice(int index, int pageSize);

    ResponseOV<DeviceType> getPageDeviceType(int page, int rows);
}
