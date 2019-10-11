package com.czk.user.utils;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ChenZK
 */
@Component
public class CookiesUtil {

    /**
     * 设置cookies
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge){
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }
    public static Cookie get(HttpServletRequest request,
                           String name){
       Cookie []cookies = request.getCookies();
       if (cookies != null){
           for (Cookie cookie : cookies){
               if (cookie.getName().equals(name)){
                   return cookie;
               }
           }
       }
       return null;
    }

}
