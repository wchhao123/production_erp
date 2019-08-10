package com.team.service;

import com.team.bean.Device;
import com.team.bean.DeviceFault;
import com.team.bean.ResponseOV;

import java.util.List;

public interface IDeviceService04 {
    ResponseOV<DeviceFault> findDeviceFaultList(int page, int rows);

    boolean deviceFaultInsert(DeviceFault deviceFault);

    boolean deviceFaultEdit(DeviceFault deviceFault);

    boolean delete_batch(String ids);

    ResponseOV<DeviceFault> search_deviceFault_by_condition(int flag, String condition, int page, int rows);

    List<Device> getDeviceList();
}
