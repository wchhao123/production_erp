package com.team.interceptor;

import com.team.util.ResourceUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object activeUser = request.getSession().getAttribute("activeUser");
        String uri = request.getRequestURI();
        String loginPage = request.getContextPath() + "/";
        String login = request.getContextPath() + "/ajaxLogin";
        String home = request.getContextPath() + "/home";

        if (activeUser == null) {
            if (ResourceUtil.isStaticResource(uri)) {
                return true;
            }
            if (!uri.equals(loginPage) && !uri.equals(login)) {
                response.sendRedirect(loginPage);
                return false;
            }
        } else {
            if (uri.equals(loginPage)) {
                response.sendRedirect(home);
                return false;
            }
        }
        return true;
    }

}
