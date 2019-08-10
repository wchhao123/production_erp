package com.team.controller;

import com.team.service.ISysUserService;
import com.team.util.UserRoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    public Map<String, String> login(String username, String password, String randomcode) {
        Map<String, String> map = new HashMap<>();
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
        int lock = userService.sysUserLogin(username, password);
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
                role.put("username", username);
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
