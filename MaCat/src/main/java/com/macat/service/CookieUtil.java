package com.macat.service;

import javax.servlet.http.Cookie;

public class CookieUtil {
	
	// 쿠키
	public static Cookie setCookie(String name, String value, int time) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		cookie.setMaxAge(time);
		return cookie;
	}

}
