package com.insurance.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {
    public static Object getValue(HttpServletRequest request, String key) {
        return request.getSession().getAttribute(key);
    }
    public static void setValue(HttpServletRequest request,String key,Object value) {
        request.getSession().setAttribute(key,value);
    }
}
