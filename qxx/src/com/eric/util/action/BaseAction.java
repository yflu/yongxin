package com.eric.util.action;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-4-25
 * Time: 下午4:56
 * To change this template use File | Settings | File Templates.
 */
public class BaseAction {
    private Gson gson = new Gson();

    protected String returnFormJson(boolean flag, Object obj) {
        Map map = new HashMap();
        map.put("success", flag);
        map.put("msg", obj);
        return gson.toJson(map);
    }

    /**
     * @param request
     * @param name
     * @param dft
     * @return
     */
    public String getString(HttpServletRequest request, String name, String dft) {
        if (request == null) {
            return dft;
        }
        String value = null;
        if (name != null) {
            value = request.getParameter(name);
        }
        if (value == null) {
            return dft;
        }
        return value;
    }

    /**
     * @param request
     * @param name
     * @param dft
     * @return
     */
    public int getInt(HttpServletRequest request, String name, int dft) {
        String value = getString(request, name);
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return dft;
        }
    }

    /**
     * @param request
     * @param name
     * @param dft
     * @return
     */
    public long getLong(HttpServletRequest request, String name, long dft) {
        String value = getString(request, name);
        try {
            return Long.parseLong(value);
        } catch (Exception e) {
            return dft;
        }
    }

    /**
     * @param request
     * @param name
     * @return
     */
    public String getString(HttpServletRequest request, String name) {
        if (request == null) {
            return null;
        }
        return request.getParameter(name);
    }

    /**
     * @param request
     * @param name
     * @param dft
     * @return
     */
    public float getFloat(HttpServletRequest request, String name, float dft) {
        String value = getString(request, name);
        try {
            return Float.parseFloat(value);
        } catch (Exception e) {
            return dft;
        }
    }
}
