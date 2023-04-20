<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>ホーム画面</title>
    </head>
    <body>
        <h1>ホーム画面</h1>

        <div>
            <c:choose>
                <c:when test="${!empty(user.loginId)}">
                    こんにちは。 <c:out value="${user.loginId}"/> さん。
                    <n:form>
                        <n:submit type="submit" uri="/action/authentication/logout/logout" value="ログアウト"/>
                    </n:form>
                </c:when>
                <c:otherwise>
                    ログインしていません。
                    <n:a href="/action/authentication/login">ログイン画面へ遷移する。</n:a>
                </c:otherwise>
            </c:choose>
        </div>

    </body>
</html>
