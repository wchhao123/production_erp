package com.team.controller;

import com.team.bean.*;
import com.team.service.IDeviceService;
import com.team.service.IOrderService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
//1.设备台账deviceList
@Controller
public class DeviceController {
    @Autowired
    private IDeviceService deviceService;

    @GetMapping("device/deviceList")
    public String find() {
        return "/WEB-INF/jsp/deviceList.jsp";
    }

    @RequestMapping("deviceList/list")
    @ResponseBody
    public ResponseOV<Device> list(int page, int rows) {
        return deviceService.getPageDevice(page, rows);
    }
    //1.1.增
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

    @PostMapping("deviceList/insert")
    @ResponseBody
    public Map<String, String> insertDevice(Device device) {
        boolean b = deviceService.insertDevice(device);
        return ControllerUtil.returnMsg(b);
    }
    //1.2.改
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
    //1.3.删除
    @GetMapping("deviceList/delete_judge")
    @ResponseBody
    public void delete_judge() {

    }
    @PostMapping("deviceList/delete_batch")
    @ResponseBody
    public Map<String, String> delete_batch(String[] ids) {
        boolean b = deviceService.delete_batch(ids);
        return ControllerUtil.returnMsg(b);
    }
    //1.4.设备台账模糊查询
    @RequestMapping(value = {"deviceList/search_device_by_deviceId",
                                "deviceList/search_device_by_deviceName",
                                "deviceList/search_device_by_deviceTypeName"})
    @ResponseBody
    public ResponseOV<Device> search_device_by_condition(HttpServletRequest request,
                                                         String searchValue,
                                                         int page,
                                                         int rows) {
        int flag;
        if (request.getRequestURI().endsWith("search_device_by_deviceId")) {
            flag = 1;
        } else if (request.getRequestURI().endsWith("search_device_by_deviceName")) {
            flag= 2;
        } else if (request.getRequestURI().endsWith("search_device_by_deviceTypeName")) {
            flag = 3;
        } else {
            flag = -1;
        }
        return deviceService.search_device_by_condition(flag,"%"+searchValue+"%", page, rows);
    }



    @GetMapping("deviceType/get/{id}")
    @ResponseBody
    public DeviceType getDeviceById(@PathVariable("id") String id) {
        return deviceService.getDeviceTypeById(id);
    }

    @GetMapping("deviceList/get_data")
    @ResponseBody
    public List<Device> getData() {
        return deviceService.getDevice();
    }
}
