package com.example.authentication.logout;

import nablarch.common.web.session.SessionUtil;
import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;

public class LogoutAction {
    public HttpResponse logout(HttpRequest req, ExecutionContext ctx) {
        SessionUtil.invalidate(ctx);
        return new HttpResponse("redirect:///action/authentication/login");
    }
}
