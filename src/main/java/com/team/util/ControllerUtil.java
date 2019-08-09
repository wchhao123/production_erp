package com.team.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerUtil {

    //保存文件
    public static void saveFile(MultipartFile file, String path) throws IOException {
        File newFile = new File(path);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        file.transferTo(newFile);

    }

    //更新、删除、新增结果返回值
    public static Map<String, String> returnMsg(boolean b) {
        Map<String,String> map = new HashMap<>();
        if (b) {
            map.put("status", "200");
            map.put("msg", "OK");
        } else {
            map.put("status", "500");
            map.put("msg", "error");
        }
        return map;
    }
}
