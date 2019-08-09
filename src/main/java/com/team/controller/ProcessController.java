package com.team.controller;

import com.team.bean.Process;
import com.team.bean.ResponseOV;
import com.team.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("process")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @GetMapping("find")
    public String find() {
        return "/WEB-INF/jsp/process_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseOV<Process> list(int page, int rows) {
        return processService.getPageProcess(page, rows);
    }


//    @RequestMapping("process/find")
//    @ResponseBody
//    public ModelAndView queryProcess(Process process){
//
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.addObject(process);
//        modelAndView.setViewName("/WEB-INF/jsp/process_list.jsp");
//        return modelAndView;
//    }
//
//    @RequestMapping("technology/find")
//    //@ResponseBody
//    public ModelAndView queryTechnology(){
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("/WEB-INF/jsp/technology_list.jsp");
//        return modelAndView;
//    }
//
//    @RequestMapping("technologyPlan/find")
//    //@ResponseBody
//    public ModelAndView queryTechnologyPlan(){
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("/WEB-INF/jsp/technologyPlan_list.jsp");
//        return modelAndView;
//    }
//
//    @RequestMapping("technologyRequirement/find")
//    @ResponseBody
//    public ModelAndView queryTechnologyRequirement(){
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("/WEB-INF/jsp/technologyRequirement_list.jsp");
//        return modelAndView;
//    }

}
