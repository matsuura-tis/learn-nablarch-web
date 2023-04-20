<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>ログイン画面</title>
    </head>
    <body>
        <n:errors filter="global" />
        <n:form>
            <div>
                <label>ログインID</label>
                <n:text name="form.loginId" />
                <n:error name="form.loginId" />
            </div>

            <div>
                <label>パスワード</label>
                <n:password name="form.password" />
                <n:error name="form.password" />
            </div>

            <n:submit type="submit" uri="/action/authentication/login/login" />
        </n:form>
    </body>
</html>
