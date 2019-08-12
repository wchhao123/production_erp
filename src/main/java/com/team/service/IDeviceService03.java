package com.team.service;

import com.team.bean.DeviceCheck;
import com.team.bean.DeviceType;
import com.team.bean.ResponseOV;

public interface IDeviceService03 {
    ResponseOV<DeviceCheck> findDeviceCheckList(int page, int rows);

    boolean deviceCheckInsert(DeviceCheck deviceCheck);

    boolean deviceCheckEdit(DeviceCheck deviceCheck);

    boolean delete_batch(String[] ids);

    ResponseOV<DeviceCheck> search_deviceCheck_by_condition(int flag, String condition, int page, int rows);
}
