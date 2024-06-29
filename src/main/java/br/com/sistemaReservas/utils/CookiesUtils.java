package br.com.sistemaReservas.utils;

import lombok.experimental.UtilityClass;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@UtilityClass
public class CookiesUtils {

    private static final String ID = "id";

    public static String getIdFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(ID)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}
