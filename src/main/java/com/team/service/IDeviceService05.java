package com.team.service;

import com.team.bean.Device;
import com.team.bean.DeviceFault;
import com.team.bean.DeviceMaintain;
import com.team.bean.ResponseOV;

import java.util.List;

public interface IDeviceService05 {
    ResponseOV<DeviceMaintain> findDeviceMaintainList(int page, int rows);

    boolean deviceMaintainInsert(DeviceMaintain deviceMaintain);

    boolean deviceMaintainEdit(DeviceMaintain deviceMaintain);

    boolean delete_batch(String[] ids);

    ResponseOV<DeviceMaintain> search_deviceMaintain_by_condition(int flag, String condition, int page, int rows);

    List<DeviceFault> getdeviceFault();
}
