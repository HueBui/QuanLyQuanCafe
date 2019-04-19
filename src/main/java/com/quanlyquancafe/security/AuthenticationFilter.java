package com.quanlyquancafe.security;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationFilter {
    String urlRedirect(HttpServletRequest request);

    static AuthenticationFilter of (String name, String pass) {

        return new AuthenticationImpl(name, pass);
    }
}
