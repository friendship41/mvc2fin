<%--
  Created by IntelliJ IDEA.
  User: stage41
  Date: 2019-12-31
  Time: 오후 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/mvc2/css/board_wrt.css" />
    <script type="text/javascript" src="/mvc2/js/script.js"></script>
    <title>글쓰기</title>
    <script type="text/javascript" src="https://jsgetip.appspot.com"></script>
    <script>
        function goGetIp() {
            console.log(ip());
            document.getElementById("ip").value=ip();
        }
        function checkWriteBoard() {
            var foorm = document.gogogo;
            if(document.getElementsByName("subject").value===""){
                alert("타이틀을 입력해 주세요");
                document.getElementsByName("subject").focus();
                return;
            }
            if(document.getElementById("content").value===""){
                alert("내용을 입력해 주세요");
                document.getElementById("content").focus();
                return;
            }
            foorm.submit();
        }
    </script>
</head>
<body onload="goGetIp()">
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
        <h1>Board</h1>
        <input type="button" value="list" class="btn" onclick="location.href='freeBoardList.do'"/> <!--게시판 목록으로 돌아가는 버튼-->
        <table id="board">
            <th id="img_bar">writing</th>
        </table>
        <div id="box">
            <div class="board">
                <c:if test="${param.ref eq null}">
                    <form method="post" action="freeBoardWriteProc.do" id="gogogo" name="gogogo">
                </c:if>
                <c:if test="${param.ref ne null}">
                    <form method="post" action="freeBoardReply.do" id="gogogo" name="gogogo">
                </c:if>
                    <div><label class="label">name</label><input type="text" required autofocus size="25" value="${requestScope.myInfo.name}" readonly name="wname"></div>
                    <div><label class="label">e-mail</label><input type="email" required size="25" value="${requestScope.myInfo.email}" readonly name="email"></div>
                    <c:if test="${requestScope.boardVO.no eq null}">
                        <div><label class="label">title</label><input type="text" required size="50" name="subject" id="subject1"></div>
                    </c:if>
                    <c:if test="${requestScope.boardVO.no ne null}">
                        <div><label class="label">title</label><input type="text" required size="50" name="subject" id="subject2" value="[답글] "></div>
                    </c:if>
                    <div><label class="label">input text</label><textarea class="text_area" name="content" required id="content"></textarea></div>
                    <div><label class="label">file</label><input type="text" readonly size="63"><input type="button" value="찾기" class="btn"></div>

                    <div class="board_btn">
<%--                        <input type="hidden" value="<%=vo.getId()%>" name="writer">--%>
                        <input type="hidden" id="ip" name="ip">
                        <input type="hidden" id="no" name="no" value="${param.no}">
                        <input type="hidden" id="ref" name="ref" value="${param.ref}">
                        <input type="hidden" id="step" name="step" value="${param.step}">
                        <input type="hidden" id="depth" name="depth" value="${param.depth}">
                        <input type="reset" value="reset" class="btn">
                        <input type="button" value="save" class="btn" onclick="checkWriteBoard()">
                    </div>
                </form>
            </div><!--.board 닫는태그-->
        </div>



        <div class="clear"></div>

    </article>



    <div class="clear"></div>
    <!-- 푸터가 들어가는 곳 -->
    <%@ include file="../../include/footer.jsp"%>

</div><!--warp 끝나는 부분-->
</body>
</html>
