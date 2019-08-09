package com.team.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRoleUtil {
    private static String[] author = {
            ":add",":edit",":delete"
    };
    public static void getAuthor(int lock, Map<String,String> map, List<String> list) {
        if (lock == 1) {
            map.put("rolename", "计划进度管理员");
            planManger(list);
        }else if(lock==3){
            map.put("processAndTechnologyName", "工序工艺管理员");
            processManager(list);
        }
    }
    private static void planManger(List<String> list) {
        for (String s: author ) {
            list.add("order" + s);
            list.add("custom" + s);
            list.add("product" + s);
        }
    }
    private static void processManager(List<String> list) {
        for (String s: author ) {
            list.add("process" + s);
            list.add("technology" + s);
            list.add("technologyPlan" + s);
            list.add("technologyRequirement"+s);
        }
    }

}
