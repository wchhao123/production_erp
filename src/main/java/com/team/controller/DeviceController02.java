package com.team.controller;

import com.team.bean.*;
import com.team.service.IDeviceService;
import com.team.service.IDeviceService02;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
//2.设备类型deviceType
@Controller
public class DeviceController02 {
    @Autowired
    private IDeviceService02 deviceService02;

    @GetMapping("device/deviceType")
    public String find02() {
        return "/WEB-INF/jsp/deviceType.jsp";
    }

    @RequestMapping("deviceType/list")
    @ResponseBody
    public ResponseOV<DeviceType> list02(int page, int rows) {
        return deviceService02.getPageDeviceType(page, rows);
    }
    //2.1 增

    @GetMapping("deviceType/add_judge")
    @ResponseBody
    public void add_judge() {

    }
    @GetMapping("deviceType/add")
    public String addJsp() {
        return "/WEB-INF/jsp/deviceType_add.jsp";
    }

    @PostMapping("deviceType/insert")
    @ResponseBody
    public Map<String, String> deviceTypeInsert(DeviceType deviceType) {
        boolean b = deviceService02.deviceTypeInsert(deviceType);
        return ControllerUtil.returnMsg(b);
    }
    //2.2 改
    @GetMapping("deviceType/edit_judge")
    @ResponseBody
    public void edit_judge() {

    }
    @GetMapping("deviceType/edit")
    public String editJsp() {
        return "/WEB-INF/jsp/deviceType_edit.jsp";
    }

    @PostMapping("deviceType/update")
    @ResponseBody
    public Map<String, String> deviceTypeEdit(DeviceType deviceType) {
        boolean b = deviceService02.deviceTypeEdit(deviceType);
        return ControllerUtil.returnMsg(b);
    }
    //2.3 删
    @GetMapping("deviceType/delete_judge")
    @ResponseBody
    public void delete_judge() {

    }
    @PostMapping("deviceType/delete_batch")
    @ResponseBody
    public Map<String, String> delete_batch(String[] ids) {
        boolean b = deviceService02.delete_batch(ids);
        return ControllerUtil.returnMsg(b);
    }
    //2.4 模糊查询
    @RequestMapping(value = {"deviceType/search_deviceType_by_deviceTypeId",
            "deviceType/search_deviceType_by_deviceTypeName"})
    @ResponseBody
    public ResponseOV<DeviceType> search_device_by_condition(HttpServletRequest request,
                                                         String searchValue,
                                                         int page,
                                                         int rows) {
        int flag;
        if (request.getRequestURI().endsWith("search_deviceType_by_deviceTypeId")) {
            flag = 1;
        } else if (request.getRequestURI().endsWith("search_deviceType_by_deviceTypeName")) {
            flag= 2;
        } else {
            flag = -1;
        }
        return deviceService02.search_deviceType_by_condition(flag,"%"+searchValue+"%", page, rows);
    }
    @RequestMapping("deviceType/get/{id}")
    @ResponseBody
    public DeviceType deviceType(@PathVariable("id") String id){
        return deviceService02.deviceType(id);
    }
}
