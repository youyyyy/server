package com.example.demo.Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    //取得cookie
    public static String getCookie(HttpServletRequest request, String key){
        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(key)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    //添加cookie
    public static void writeCookie(HttpServletResponse response, String key, String value){
        Cookie cookie = new Cookie(key,value);
        cookie.setPath("/user/login");
        cookie.setMaxAge(60*60*24*7);
        response.addCookie(cookie);
    }

    //删除cookie
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String key){
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(key)) {
                    Cookie cookie = new Cookie(key,null);
                    cookie.setPath("/user/login");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
                }
            }

        }
}
