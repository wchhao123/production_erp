package com.team.controller;

import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FileController {

    @Autowired
    private ServletContext context;

    @RequestMapping("file/upload")
    @ResponseBody
    public Map<String, String> uploadFile(MultipartFile file) {
        Map<String, String> map = new HashMap<>();
        String fileRelativePath = "/file/" + file.getOriginalFilename();
        try {
            ControllerUtil.saveFile(file, context.getRealPath("/WEB-INF/upload" + fileRelativePath));
            map.put("error", "0");
            map.put("url", fileRelativePath);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("error", "1");
        return map;
    }

    @RequestMapping("file/delete")
    @ResponseBody
    public Map<String, String> deleteFile(String fileName) {
        File file = new File(context.getRealPath("/WEB-INF/upload" + fileName));
        if (file.exists())
            file.delete();
        Map<String,String> map = new HashMap<>();
        map.put("data", "success");
        return map;
    }

    @RequestMapping("file/download")
    public String fileDownLoad(String fileName) {
        return "redirect:" + fileName;
    }

    @RequestMapping("img/upload")
    @ResponseBody
    public Map<String, String> uploadImg() {
        System.out.println("map");
        return null;
    }
}
