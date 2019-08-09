package com.team.controller;

import com.team.bean.COrder;
import com.team.bean.Device;
import com.team.bean.ResponseOV;
import com.team.service.IDeviceService;
import com.team.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("device")
public class DeviceController {
    @GetMapping("deviceList")
    public String find() {
        return "/WEB-INF/jsp/deviceList.jsp";
    }

    @GetMapping("deviceType")
    public String find02() {
        return "/WEB-INF/jsp/deviceType.jsp";
    }
}
