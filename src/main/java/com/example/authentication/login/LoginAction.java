package com.example.authentication.login;

import com.example.authentication.component.AuthenticationUtil;
import com.example.authentication.component.exception.AuthenticationFailedException;
import com.example.authentication.component.exception.PasswordExpiredException;
import com.example.authentication.component.exception.UserIdLockedException;
import com.example.entity.SystemAccount;
import nablarch.common.dao.UniversalDao;
import nablarch.common.web.interceptor.InjectForm;
import nablarch.common.web.session.SessionUtil;
import nablarch.core.message.ApplicationException;
import nablarch.core.message.MessageLevel;
import nablarch.core.message.MessageUtil;
import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;
import nablarch.fw.web.interceptor.OnError;

public class LoginAction {
    public HttpResponse index(HttpRequest req, ExecutionContext ctx) {
        return new HttpResponse("/WEB-INF/authentication/login/login.jsp");
    }

    @InjectForm(form = LoginForm.class, prefix = "form")
    @OnError(type = ApplicationException.class, path = "/WEB-INF/authentication/login/login.jsp")
    public HttpResponse login(HttpRequest req, ExecutionContext ctx) {
        LoginForm form = ctx.getRequestScopedVar("form");

        try {
            AuthenticationUtil.authenticate(form.getLoginId(), form.getPassword());
        } catch (AuthenticationFailedException | UserIdLockedException | PasswordExpiredException e) {
            // TODO: ユーザにロック状態やパスワード有効期限切れを伝える。
            throw new ApplicationException(MessageUtil.createMessage(MessageLevel.ERROR, "action.authentication.login.authenticationFailed"));
        }

        var user = UniversalDao.findBySqlFile(SystemAccount.class, "FIND_SYSTEM_ACCOUNT_BY_LOGIN_ID", form);

        SessionUtil.changeId(ctx);

        // TODO: CSRFトークンを再生成する（CSRFトークン検証ハンドラを使用している場合）
        // CsrfTokenUtil.regenerateCsrfToken(ctx);

        SessionUtil.put(ctx, "userId", user.getUserId(), "db");

        return new HttpResponse("redirect:///action/navigation/home");
    }

}
