<%--
  Created by IntelliJ IDEA.
  User: stage41
  Date: 2020-01-13
  Time: 오후 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/mvc2/css/idcheck.css" />
    <script type="text/javascript" src="/mvc2/js/script.js"></script>
    <title>중복확인 결과</title>
</head>
<body>
<div id="warp">
    <article id="contents">
        <div class="nothing"></div>
        <div class="chil">${requestScope.msg}</div>
        <div class="chil"><input type="button" value="닫기" class="btn" onclick="window.close()"/></div>
    </article>
</div>
</body>
</html>


