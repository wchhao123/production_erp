package com.team.controller;

import com.team.bean.SysUser;
import com.team.service.ISysUserService;
import com.team.util.UserRoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private ISysUserService userService;

    @Autowired
    private HttpSession session;

    @GetMapping("/")
    public String toLogin() {
        return "/WEB-INF/jsp/login.jsp";
    }

    @PostMapping("ajaxLogin")
    @ResponseBody
    public Map<String, String> login(@Validated SysUser user,BindingResult bindingResult,
                                     String randomcode ) {

        Map<String, String> map = new HashMap<>();

        //数据校验
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String defaultMessage = fieldError.getDefaultMessage();
            map.put("msg", "error");
            map.put("error", defaultMessage);
            return map;
        }

        //验证码
        if (randomcode!= null) {
            String validateCode = (String)session.getAttribute("validateCode");
            if (!randomcode.equals(validateCode)) {
                map.put("msg","randomcode_error");
                return map;
            }
        }

        Map<String, String> role = new HashMap<>();
        List<String> author = new ArrayList<>();
        //用户验证
        int lock = userService.sysUserLogin(user.getUsername(), user.getPassword());
        switch (lock) {
            case -2:
                map.put("msg", "account_error");
                break;
            case -1:
                map.put("msg", "password_error");
                break;
            case 0:
                map.put("msg", "authentication_error");
                break;
            default:
                map.put("msg", "success");
                role.put("username", user.getUsername());
                UserRoleUtil.getAuthor(lock, role, author);
                session.setAttribute("activeUser", role);
                session.setAttribute("sysPermissionList", author);
                break;
        }

        return map;
    }

    @RequestMapping("home")
    public String home() {
        return "/WEB-INF/jsp/home.jsp";
    }

    @RequestMapping("logout")
    public String logout() {
        session.removeAttribute("activeUser");
        session.removeAttribute("sysPermissionList");
        return "redirect:/";
    }

}
