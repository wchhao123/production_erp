package com.team.controller;

import com.team.bean.*;
import com.team.service.IDeviceService;
import com.team.service.IDeviceService03;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class DeviceController03 {
    @Autowired
    private IDeviceService03 deviceService03;

    //3.设备例检
    @GetMapping("device/deviceCheck")
    public String getDeviceCheckJsp(){
        return "/WEB-INF/jsp/deviceCheck.jsp";
    }

    @RequestMapping("deviceCheck/list")
    @ResponseBody
    public ResponseOV<DeviceCheck> findDeviceCheckList(int page, int rows){
        return deviceService03.findDeviceCheckList(page,rows);
    }
    //3.1 增
    //2.1 设备种类新增

    @GetMapping("deviceCheck/add_judge")
    @ResponseBody
    public void add_judge() {

    }
    @GetMapping("deviceCheck/add")
    public String addJsp() {
        return "/WEB-INF/jsp/deviceCheck_add.jsp";
    }

    @PostMapping("deviceCheck/insert")
    @ResponseBody
    public Map<String, String> deviceCheckInsert(DeviceCheck deviceCheck) {
        boolean b = deviceService03.deviceCheckInsert(deviceCheck);
        return ControllerUtil.returnMsg(b);
    }
    //2.2 设备种类修改
    @GetMapping("deviceCheck/edit_judge")
    @ResponseBody
    public void edit_judge() {

    }
    @GetMapping("deviceCheck/edit")
    public String editJsp() {
        return "/WEB-INF/jsp/deviceCheck_edit.jsp";
    }

    @PostMapping("deviceCheck/update")
    @ResponseBody
    public Map<String, String> deviceCheckEdit(DeviceCheck deviceCheck) {
        boolean b = deviceService03.deviceCheckEdit(deviceCheck);
        return ControllerUtil.returnMsg(b);
    }
    //2.3 设备种类删除
    @GetMapping("deviceCheck/delete_judge")
    @ResponseBody
    public void delete_judge() {

    }
    @PostMapping("deviceCheck/delete_batch")
    @ResponseBody
    public Map<String, String> delete_batch(String ids) {
        boolean b = deviceService03.delete_batch(ids);
        return ControllerUtil.returnMsg(b);
    }
    //2.4 模糊查询
    @RequestMapping(value = {"deviceCheck/search_deviceCheck_by_deviceCheckId",
            "deviceCheck/search_deviceCheck_by_deviceName"})
    @ResponseBody
    public ResponseOV<DeviceCheck> search_deviceCheck_by_condition(HttpServletRequest request,
                                                             String searchValue,
                                                             int page,
                                                             int rows) {
        int flag;
        if (request.getRequestURI().endsWith("search_deviceCheck_by_deviceCheckId")) {
            flag = 1;
        } else if (request.getRequestURI().endsWith("search_deviceCheck_by_deviceName")) {
            flag= 2;
        } else {
            flag = -1;
        }
        return deviceService03.search_deviceCheck_by_condition(flag,"%"+searchValue+"%", page, rows);
    }
}
