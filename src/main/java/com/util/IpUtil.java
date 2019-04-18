package com.util;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

/**
 * Created by lvjianqing on 2017/8/1.
 */
public class IpUtil {
    private static Logger log = Logger.getLogger(IpUtil.class);

    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        try {
            ip = ip.split(",")[0];
        } catch (Exception e) {
        }
        ip = StringUtil.blanknull(ip);
        return ip;
    }

    public static String getLocalIp() {
        String ip = "";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            ip = addr.getHostAddress().toString();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return ip;
    }
}
