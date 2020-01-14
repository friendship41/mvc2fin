<%--
  Created by IntelliJ IDEA.
  User: stage41
  Date: 2020-01-13
  Time: 오후 2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/mvc2/css/board_del.css" /><!--게시판글 삭제 css-->
    <script type="text/javascript" src="/mvc2/js/script.js"></script>
    <title>회원탈퇴</title>
</head>
<body>
<div id="warp">
    <!--헤더파일 들어가는 곳-->
    <%@ include file="../../include/header.jsp" %>

    <!--그림파일 들어가는 곳 없어도 되지만 한번 넣어보자-->
    <div id="sub_img">
    </div>
    <!--왼쪽의 서브메뉴가 들어가는 곳-->
    <%@ include file="../../include/left.jsp" %>

    <!--실제 내용 콘텐츠가 들어가는 곳-->
    <article id="contents">
        <h1>delete</h1>
        <div id="del_box">
            <form method="post" action="memberDelProc.do">
                <div id="del">
                    <label>탈퇴하기</label>
                    <input type="password" required size="10" name="pw">
                </div>
                <div id="del_btn">
                    <label><input type="submit" value="탈퇴하기" class="btn"></label>
                    <label><input type="button" value="취소" class="btn" onclick="history.back()"></label></div>
                </fieldset>
            </form></div>
        <div class="clear"></div>

    </article>



    <div class="clear"></div>
    <!-- 푸터가 들어가는 곳 -->
    <%@ include file="../../include/footer.jsp" %>

</div><!--warp 끝나는 부분-->
</body>
</html>

