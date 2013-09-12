package com.eric.util.tool;

import java.util.ResourceBundle;

public class ParsProperFile {
    private static ResourceBundle appProcBud = ResourceBundle.getBundle("app");

    public static String getRyAppProp(String key) {
        return appProcBud.getString(key);
    }
}
