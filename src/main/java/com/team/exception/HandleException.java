package com.team.exception;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HandleException implements HandlerExceptionResolver {

    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/error.jsp");
        modelAndView.addObject("message", e.getMessage());
        return modelAndView;
    }
}
