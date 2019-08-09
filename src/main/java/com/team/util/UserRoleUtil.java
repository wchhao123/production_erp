package com.team.util;

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
        }else if (lock==2) {
            map.put("rolename", "设备管理管理员");
            deviceManger(list);
        } else if (lock == 5) {
            map.put("rolename", "质量监控管理员");
            qualifyMonitor(list);
        }

    }
    private static void qualifyMonitor(List<String> list) {
        for (String s: author ) {
            list.add("unqualify" + s);
            list.add("fMeasureCheck" + s);
            list.add("fCountCheck" + s);
            list.add("pMeasureCheck" + s);
            list.add("pCountCheck" + s);
        }
    }

    private static void deviceManger(List<String> list) {
        for (String s  : author) {
            list.add("device" + s);
            list.add("deviceType" + s);
            list.add("deviceCheck" + s);
            list.add("deviceFault" + s);
            list.add("deviceMaintain" + s);
        }
    }
    private static void planManger(List<String> list) {
        for (String s: author ) {
            list.add("order" + s);
            list.add("custom" + s);
            list.add("product" + s);
        }
    }

}
