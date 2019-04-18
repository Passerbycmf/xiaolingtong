package com.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie cookies[] = request.getCookies();
		if (cookies == null || name == null || name.length() == 0) {
			return null;
		}
		for (int i = 0; i < cookies.length; i++) {
			if (name.equals(cookies[i].getName())) {
				return cookies[i];
			}
		}
		return null;
	}

	public static String getCookieValue(HttpServletRequest request, String name) {
		Cookie cookies[] = request.getCookies();
		if (cookies == null || name == null || name.length() == 0) {
			return "";
		}
		for (int i = 0; i < cookies.length; i++) {
			if (name.equals(cookies[i].getName())) {
				return cookies[i].getValue();
			}
		}
		return "";
	}
	
	public static void addCookie(HttpServletRequest request,
                                 HttpServletResponse response, Cookie cookie, int maxAge) {
		if (cookie != null) {
			cookie.setMaxAge(maxAge);
			cookie.setPath("/");
            cookie.setDomain(Config.getString("cookie.domain",Config.getString("cookie.domain")));
			response.addCookie(cookie);
		}
	}
	/*
	 * 根据cookie删除 cookie
	 */
	public static void deleteCookie(HttpServletRequest request,
                                    HttpServletResponse response, Cookie cookie) {
		if (cookie != null) {
			cookie.setMaxAge(0);
			cookie.setPath("/");
			cookie.setDomain(Config.getString("cookie.domain",Config.getString("cookie.domain")));
			response.addCookie(cookie);
		}
	}
	/*
	 * 根据cookie key 删除 cookie
	 */
	public static void deleteCookie(HttpServletRequest request,
                                    HttpServletResponse response, String name) {
		Cookie cookie = CookieUtil.getCookie(request, name);
		if (cookie != null) {
			cookie.setMaxAge(0);
			cookie.setValue("");
			cookie.setPath("/");
			cookie.setDomain(Config.getString("cookie.domain",Config.getString("cookie.domain")));
			response.addCookie(cookie);
		}
	}

	public static void setCookie(HttpServletRequest request,
                                 HttpServletResponse response, String name, String value) {
		setCookie(request, response, name, value, 0x278d00);
	}
	
	public static void setCookie(HttpServletResponse response, String name, String value) {
		setCookie(response, name, value, 0x278d00);
	}

	public static void setCookie(HttpServletRequest request,
                                 HttpServletResponse response, String name, String value, int maxAge) {
		Cookie cookie = new Cookie(name, value == null ? "" : value);
		cookie.setMaxAge(maxAge);
		cookie.setPath("/");
		cookie.setDomain(Config.getString("cookie.domain",Config.getString("cookie.domain")));
		response.addCookie(cookie);
	}
	
	public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
		Cookie cookie = new Cookie(name, value == null ? "" : value);
		cookie.setMaxAge(maxAge);
		cookie.setPath("/");
		cookie.setDomain(Config.getString("cookie.domain",Config.getString("cookie.domain")));
		response.addCookie(cookie);
	}

	private static String getPath(HttpServletRequest request) {
		String path = request.getContextPath();
		return (path == null || path.length() == 0) ? "/" : path;
	}
	
	public static String getUniqueCookie(){
		long l = System.currentTimeMillis();
		int n = (int)(Math.random()*1000000);
		return l+""+n;
	}
}
