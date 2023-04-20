package com.example.navigation.home;

import com.example.entity.SystemAccount;
import nablarch.common.dao.UniversalDao;
import nablarch.common.web.session.SessionUtil;
import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;

public class HomeAction {
    public HttpResponse index(HttpRequest req, ExecutionContext ctx) {

        var userId = SessionUtil.orNull(ctx, "userId");
        if (userId != null) {
            var user = UniversalDao.findById(SystemAccount.class, userId);
            ctx.setRequestScopedVar("user", user);
        }

        return new HttpResponse("/WEB-INF/navigation/home/home.jsp");
    }
}
