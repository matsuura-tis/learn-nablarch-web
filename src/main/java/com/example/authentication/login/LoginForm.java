package com.example.authentication.login;

import nablarch.core.validation.ee.Domain;
import nablarch.core.validation.ee.Required;

import java.io.Serial;
import java.io.Serializable;

public class LoginForm implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Domain("loginId")
    @Required
    private String loginId;

    @Domain("password")
    @Required
    private String password;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
