package com.team.controller;

import com.team.bean.Device;
import com.team.bean.ResponseOV;
import com.team.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("deviceList")
public class DeviceController02 {

    @Autowired
    private IDeviceService deviceService;

    @RequestMapping("list")
    @ResponseBody
    public ResponseOV<Device> list(int page, int rows) {
        return deviceService.getPageDevice(page, rows);
    }
}
