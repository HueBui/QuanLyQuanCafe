package com.quanlyquancafe.security;

import com.quanlyquancafe.model.UserModel;
import com.quanlyquancafe.service.IUserService;
import com.quanlyquancafe.service.impl.UserService;
import com.quanlyquancafe.utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationImpl implements AuthenticationFilter {
    private IUserService userService;

    private String name;
    private String pass;

    public AuthenticationImpl(String name, String pass) {
        this.name = name;
        this.pass = pass;
        userService = new UserService();
    }

    @Override
    public String urlRedirect(HttpServletRequest request) {

        UserModel model = userService.findByUserNameAndPasswordAndStatus(this.name, this.pass, 1);
        if (model != null) {
            SessionUtil.getInstance().putValue(request, "USERMODEL", model);
            if (model.getRole().getCode().equals("ORDER")) {
                return "/order";
            } else if (model.getRole().getCode().equals("ADMIN")) {
                return "/admin-home";
            } else {
                return "/management";
            }
        } else {
            return "/dang-nhap?action=loginFalse";
        }
    }
}
