package net.i2it.hit.hit_alumni.util;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {

    public static String getFullUrl(HttpServletRequest request) {
        //request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
        return request.getRequestURL() + "?" + request.getQueryString();
    }

}
