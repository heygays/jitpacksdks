package com.sly.sdks.utils;

public class CommonUtils {
    public static String test() {
        return "testOK";
    }

    /**
     * @param classPath
     * @return
     * @description 根据包名路径获取Class对象
     */
    public static Class<?> getClassByPath(String classPath) {
        try {
            return Class.forName(classPath);
        } catch (Exception e) {
            return null;
        }
    }
}
