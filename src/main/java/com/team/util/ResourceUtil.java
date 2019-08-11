package com.team.util;

public class ResourceUtil {

    private static String[] staticResource = {
            "/image/", "/css/", "/js/"
    };

    public static boolean isStaticResource(String uri) {
        boolean flag = false;
        for (String s : staticResource) {
            if (uri.startsWith(s)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
