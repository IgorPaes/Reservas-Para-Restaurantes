package br.com.sistemaReservas.utils;

import lombok.experimental.UtilityClass;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@UtilityClass
public class CookiesUtils {

    private static final String EMAIL = "email";

    public static String getEmailFromCookie(HttpServletRequest request) {
        // Implemente a lógica para extrair o email do cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(EMAIL)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}
