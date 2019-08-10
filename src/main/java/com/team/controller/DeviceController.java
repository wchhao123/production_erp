package com.team.controller;

import com.team.bean.*;
import com.team.service.IDeviceService;
import com.team.service.IOrderService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    //1.1.设备台账新增
    @GetMapping("deviceList/add_judge")
    @ResponseBody
    public void getJsp() {

    }
    @GetMapping("deviceList/add")
    public String appPage() {
        return "/WEB-INF/jsp/deviceList_add.jsp";
    }
    @PostMapping("deviceType/get_data")
    @ResponseBody
    public List<DeviceType> getDeviceTypeList() {
        return deviceService.getDeviceTypeList();
    }
    @PostMapping("employee/get_data")
    @ResponseBody
    public List<Employee> getEmployeeList() {
        return deviceService.getEmployeeList();
    }
    @PostMapping("deviceList/insert")
    @ResponseBody
    public Map<String, String> insertDevice(Device device) {
        boolean b = deviceService.insertDevice(device);
        return ControllerUtil.returnMsg(b);
    }
    //1.2.设备台账修改
    @GetMapping("deviceList/edit_judge")
    @ResponseBody
    public void edit_judge() {

    }
    @GetMapping("deviceList/edit")
    public String edit() {
        return "/WEB-INF/jsp/deviceList_edit.jsp";
    }
    @PostMapping("deviceList/update")
    @ResponseBody
    public Map<String, String> update(Device device) {
        boolean b = deviceService.update(device);
        return ControllerUtil.returnMsg(b);
    }
    //1.3.设备台账删除
    @GetMapping("deviceList/delete_judge")
    @ResponseBody
    public void delete_judge() {

    }
    @PostMapping("deviceList/delete_batch")
    @ResponseBody
    public Map<String, String> delete_batch(String ids) {
        boolean b = deviceService.delete_batch(ids);
        return ControllerUtil.returnMsg(b);
    }
    //1.4.设备台账模糊查询
    // deviceList/search_device_by_deviceName?searchValue=叉&page=1&rows=30
    @RequestMapping("deviceList/search_device_by_deviceName")
    @ResponseBody
    public ResponseOV<Device> search_device_by_deviceName(String searchValue,int page, int rows) {
        return deviceService.search_device_by_deviceName("%"+searchValue+"%",page,rows);
    }
    //deviceList/search_device_by_deviceId?searchValue=003&page=1&rows=30
    //deviceList/search_device_by_deviceTypeName?searchValue=传送&page=1&rows=30
    //deviceList/list?page=1&rows=30（什么条件也填时）







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
}
