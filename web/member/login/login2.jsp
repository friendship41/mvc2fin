<%--
  Created by IntelliJ IDEA.
  User: stage41
  Date: 2020-01-13
  Time: 오후 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.id eq null}">
    <c:redirect url="login.do"></c:redirect>
</c:if>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/mvc2/css/login_form.css" /><!--login css-->
    <script type="text/javascript" src="/mvc2/js/script.js"></script>
    <script type="text/javascript" src="/mvc2/js/alertMsg.js"></script>
    <title>내 정보</title>
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
            <div id="modify_wrap">
                <h1>${sessionScope.id}님 환영합니다.</h1>
                <form>

                    <div id="modify_btn">
                        <label><input type="button" value="정보수정" class="btn" onclick="location.href='memberMod.do'"></label>
                        <label><input type="button" value="회원탈퇴" class="btn" onclick="location.href='memberDel.do'"></label>
                        <label><input type="button" value="로그아웃" class="btn" onclick="location.href='logoutProc.do'"></label></div>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="clear"></div>

    </article>
    <div class="clear"></div>
    <!-- 푸터가 들어가는 곳 -->
    <%@ include file="../../include/footer.jsp"%>

</div><!--warp 끝나는 부분-->
</body>
</html>
