package com.team.controller;

import com.team.bean.Device;
import com.team.bean.DeviceFault;
import com.team.bean.DeviceMaintain;
import com.team.bean.ResponseOV;
import com.team.service.IDeviceService05;
import com.team.service.IDeviceService05;
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
public class DeviceController05 {
    @Autowired
    private IDeviceService05 deviceService05;

    //3.设备例检
    @GetMapping("device/deviceMaintain")
    public String getDeviceMaintainJsp(){
        return "/WEB-INF/jsp/deviceMaintain.jsp";
    }

    @RequestMapping("deviceMaintain/list")
    @ResponseBody
    public ResponseOV<DeviceMaintain> findDeviceMaintainList(int page, int rows){
        return deviceService05.findDeviceMaintainList(page,rows);
    }
    //3.1 增
    //2.1 设备种类新增

    @GetMapping("deviceMaintain/add_judge")
    @ResponseBody
    public void add_judge() {

    }
    @GetMapping("deviceMaintain/add")
    public String addJsp() {
        return "/WEB-INF/jsp/deviceMaintain_add.jsp";
    }

//    deviceFault/get_data（deviceFault/get_data、、、、employee/get_data）
    @PostMapping("deviceFault/get_data")
    @ResponseBody
    public List<DeviceFault> getdeviceFault() {
        return deviceService05.getdeviceFault();
    }

    @PostMapping("deviceMaintain/insert")
    @ResponseBody
    public Map<String, String> deviceMaintainInsert(DeviceMaintain deviceMaintain) {
        boolean b = deviceService05.deviceMaintainInsert(deviceMaintain);
        return ControllerUtil.returnMsg(b);
    }
    //2.2 设备种类修改
    @GetMapping("deviceMaintain/edit_judge")
    @ResponseBody
    public void edit_judge() {

    }
    @GetMapping("deviceMaintain/edit")
    public String editJsp() {
        return "/WEB-INF/jsp/deviceMaintain_edit.jsp";
    }

    @PostMapping("deviceMaintain/update")
    @ResponseBody
    public Map<String, String> deviceMaintainEdit(DeviceMaintain deviceMaintain) {
        boolean b = deviceService05.deviceMaintainEdit(deviceMaintain);
        return ControllerUtil.returnMsg(b);
    }
    //2.3 设备种类删除
    @GetMapping("deviceMaintain/delete_judge")
    @ResponseBody
    public void delete_judge() {

    }
    @PostMapping("deviceMaintain/delete_batch")
    @ResponseBody
    public Map<String, String> delete_batch(String ids) {
        boolean b = deviceService05.delete_batch(ids);
        return ControllerUtil.returnMsg(b);
    }
    //2.4 模糊查询
    @RequestMapping(value = {"deviceMaintain/search_deviceMaintain_by_deviceMaintainId",
            "deviceMaintain/search_deviceMaintain_by_deviceFaultId"})
    @ResponseBody
    public ResponseOV<DeviceMaintain> search_deviceMaintain_by_condition(HttpServletRequest request,
                                                             String searchValue,
                                                             int page,
                                                             int rows) {
        int flag;
        if (request.getRequestURI().endsWith("search_deviceMaintain_by_deviceMaintainId")) {
            flag = 1;
        } else if (request.getRequestURI().endsWith("search_deviceMaintain_by_deviceFaultId")) {
            flag= 2;
        } else {
            flag = -1;
        }
        return deviceService05.search_deviceMaintain_by_condition(flag,"%"+searchValue+"%", page, rows);
    }
}
