package com.team.controller;

import com.team.bean.Device;
import com.team.bean.DeviceFault;
import com.team.bean.DeviceType;
import com.team.bean.ResponseOV;
import com.team.service.IDeviceService04;
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
public class DeviceController04 {
    @Autowired
    private IDeviceService04 deviceService04;

    //3.设备例检
    @GetMapping("device/deviceFault")
    public String getDeviceFaultJsp(){
        return "/WEB-INF/jsp/deviceFault.jsp";
    }

    @RequestMapping("deviceFault/list")
    @ResponseBody
    public ResponseOV<DeviceFault> findDeviceFaultList(int page, int rows){
        return deviceService04.findDeviceFaultList(page,rows);
    }
    //3.1 增
    //2.1 设备种类新增

    @GetMapping("deviceFault/add_judge")
    @ResponseBody
    public void add_judge() {

    }
    @GetMapping("deviceFault/add")
    public String addJsp() {
        return "/WEB-INF/jsp/deviceFault_add.jsp";
    }

//    deviceList/get_data
    @PostMapping("deviceList/get_data")
    @ResponseBody
    public List<Device> getDeviceList() {
        return deviceService04.getDeviceList();
    }

    @PostMapping("deviceFault/insert")
    @ResponseBody
    public Map<String, String> deviceFaultInsert(DeviceFault deviceFault) {
        boolean b = deviceService04.deviceFaultInsert(deviceFault);
        return ControllerUtil.returnMsg(b);
    }
    //2.2 设备种类修改
    @GetMapping("deviceFault/edit_judge")
    @ResponseBody
    public void edit_judge() {

    }
    @GetMapping("deviceFault/edit")
    public String editJsp() {
        return "/WEB-INF/jsp/deviceFault_edit.jsp";
    }

    @PostMapping("deviceFault/update")
    @ResponseBody
    public Map<String, String> deviceFaultEdit(DeviceFault deviceFault) {
        boolean b = deviceService04.deviceFaultEdit(deviceFault);
        return ControllerUtil.returnMsg(b);
    }
    //2.3 设备种类删除
    @GetMapping("deviceFault/delete_judge")
    @ResponseBody
    public void delete_judge() {

    }
    @PostMapping("deviceFault/delete_batch")
    @ResponseBody
    public Map<String, String> delete_batch(String ids) {
        boolean b = deviceService04.delete_batch(ids);
        return ControllerUtil.returnMsg(b);
    }
    //2.4 模糊查询
    @RequestMapping(value = {"deviceFault/search_deviceFault_by_deviceFaultId",
            "deviceFault/search_deviceFault_by_deviceName"})
    @ResponseBody
    public ResponseOV<DeviceFault> search_deviceFault_by_condition(HttpServletRequest request,
                                                             String searchValue,
                                                             int page,
                                                             int rows) {
        int flag;
        if (request.getRequestURI().endsWith("search_deviceFault_by_deviceFaultId")) {
            flag = 1;
        } else if (request.getRequestURI().endsWith("search_deviceFault_by_deviceName")) {
            flag= 2;
        } else {
            flag = -1;
        }
        return deviceService04.search_deviceFault_by_condition(flag,"%"+searchValue+"%", page, rows);
    }
}
