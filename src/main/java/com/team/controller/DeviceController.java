package com.team.controller;

import com.team.bean.*;
import com.team.service.IDeviceService;
import com.team.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceController {
    @Autowired
    private IDeviceService deviceService;

    //1.设备台账
    @GetMapping("device/deviceList")
    public String find() {
        return "/WEB-INF/jsp/deviceList.jsp";
    }

    @RequestMapping("deviceList/list")
    @ResponseBody
    public ResponseOV<Device> list(int page, int rows) {
        return deviceService.getPageDevice(page, rows);
    }

    //2.设备种类
    @GetMapping("device/deviceType")
    public String find02() {
        return "/WEB-INF/jsp/deviceType.jsp";
    }

    @RequestMapping("deviceType/list")
    @ResponseBody
    public ResponseOV<DeviceType> list02(int page, int rows) {
        return deviceService.getPageDeviceType(page, rows);
    }

    //3.设备例检
    @GetMapping("device/deviceCheck")
    public String getDeviceCheckJsp(){
        return "/WEB-INF/jsp/deviceCheck.jsp";
    }

    @RequestMapping("deviceCheck/list")
    @ResponseBody
    public ResponseOV<DeviceCheck> findDeviceCheckList(int page, int rows){
        return deviceService.findDeviceCheckList(page,rows);
    }

    //4.设备故障
    @GetMapping("device/deviceFault")
    public String getdeviceFaultJsp(){
        return "/WEB-INF/jsp/deviceFault.jsp";
    }

    @RequestMapping("deviceFault/list")
    @ResponseBody
    public ResponseOV<DeviceFault> finddeviceFaultList(int page, int rows){
        return deviceService.findDeviceFaultList(page,rows);
    }

    //5.设备维修
    @GetMapping("device/deviceMaintain")
    public String getDeviceMaintainJsp(){
        return "/WEB-INF/jsp/deviceMaintain.jsp";
    }

    @RequestMapping("deviceMaintain/list")
    @ResponseBody
    public ResponseOV<DeviceMaintain> findDeviceMaintainList(int page, int rows){
        return deviceService.findDeviceMaintainList(page,rows);
    }

    @GetMapping("deviceList/get/{id}")
    @ResponseBody
    public Device getDeviceById(@PathVariable("id") String id) {
        return deviceService.getDeviceById(id);
    }

    @GetMapping("deviceList/get_data")
    @ResponseBody
    public List<Device> getData() {
        return deviceService.getDevice();
    }
}
