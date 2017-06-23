package net.i2it.hit.hit_alumni.util;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {

    public static String getFullUrl(HttpServletRequest request) {
        return request.getQueryString() != null ?
                (request.getRequestURL() + "?" + request.getQueryString()) : (request.getRequestURL() + "");
    }

}
