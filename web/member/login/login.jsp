<%--
  Created by IntelliJ IDEA.
  User: stage41
  Date: 2020-01-13
  Time: 오전 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.id ne null}">
    <c:redirect url="login2.do"></c:redirect>
</c:if>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/mvc2/css/login_form.css" />
    <script type="text/javascript" src="/mvc2/js/script.js"></script>
    <script type="text/javascript" src="/mvc2/js/alertMsg.js"></script>
    <title>로그인</title>
    <script>
        alertMsg('${requestScope.msg}');
    </script>
</head>
<body>
<div id="warp">
    <!--헤더파일 들어가는 곳-->
    <%@ include file="../../include/header.jsp"%>

    <!--그림파일 들어가는 곳 없어도 되지만 한번 넣어보자-->
    <div id="sub_img">
    </div>
    <!--왼쪽의 서브메뉴가 들어가는 곳-->
    <%@ include file="../../include/left.jsp"%>

    <!--실제 내용 콘텐츠가 들어가는 곳-->
    <article id="contents">

        <div id="login_box">
            <form method="post" action="loginProc.do">
                <fieldset>
                    <legend>Login</legend>
                    <div>
                        <label class="login_form">아이디: </label><input type="text" id="user_login_id" name="id" size="15" required placeholder="ID입력">
                    </div>
                    <div>
                        <label class="login_form">비밀번호: </label><input type="password" id="user_login_pw" name="pw" size="15" required placeholder="Password입력">
                    </div>
                    <div id="lo_btn">
                        <label><input type="submit" value="LOGIN" class="btn"></label>
                        <label><input type="button" value="JOIN" class="btn" onclick="goToJoin()"></label>
                        <label><input type="button" value="ID/PW 찾기" class="btn" onclick="location.href='findIDPW.do'"></label>
                    </div>
                </fieldset>
            </form>

        </div>

        <div class="clear"></div>

    </article>



    <div class="clear"></div>
    <!-- 푸터가 들어가는 곳 -->
    <%@ include file="../../include/footer.jsp"%>

</div><!--warp 끝나는 부분-->
</body>
</html>


