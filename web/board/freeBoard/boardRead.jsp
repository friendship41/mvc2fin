<%--
  Created by IntelliJ IDEA.
  User: stage41
  Date: 2020-01-14
  Time: 오후 4:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/mvc2/css/board_read.css" />
    <script type="text/javascript" src="/mvc2/js/script.js"></script>
    <title>${requestScope.boardVO.subject}</title>
    <script>
        function goTOMod() {
            var url = "freeBoardMod.do?no=${requestScope.boardVO.no}";
            location.href=url;
        }
        function goTOReply() {
            <%--var url1 = "/jsp_homepage1/board1/writeBoard1.jsp?no="+<%=no%>;--%>
            <%--var url2 = url1+"&ref="+<%=board1VO.getRef()%>;--%>
            <%--var url3 = url2+"&step="+<%=board1VO.getStep()%>;--%>
            <%--var url4 = url3+"&depth="+<%=board1VO.getDepth()%>;--%>
            <%--location.href=url4;--%>
        }
        function deleteConfirm() {
            <%--var confirmm = confirm("정말로 삭제하시겠습니까?");--%>
            <%--if(confirmm === true)--%>
            <%--{--%>
            <%--    location.href="/jsp_homepage1/board1/procDeleteBoard.jsp?no="+<%=no%>;--%>
            <%--}--%>
        }
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
        <h1>게시글 보기</h1>
        <div id="read_warp">
            <span class="read_board"><h2>글번호</h2></span>
            <span><h3>${requestScope.boardVO.no}</h3></span>
            <span class="read_board"><h2>조회수</h2></span><span><h3>${requestScope.boardVO.readcnt}</h3></span>
            <span class="read_board"><h2>글제목</h2></span><span id="read_title"><h3>${requestScope.boardVO.subject}</h3></span>

            <span id="bd_text"><h4>${requestScope.boardVO.content}</h4></span>
            <%--            <span class="read_board"><h2>첨부파일보기</h2></span><span id="file"><input type="text" size="35" readonly>--%>
            <%--												<input type="button" value="받기" class="btn"></span>--%>
            <div id="read_btn">

                <c:if test="${requestScope.myName ne null}">
                    <c:choose>
                        <c:when test="${requestScope.myName eq requestScope.boardVO.writer}">
                            <input type="button" value="글수정" class="btn" onclick="goTOMod()">
                            <input type="button" value="글삭제" class="btn" onclick="deleteConfirm()">
                        </c:when>
                        <c:otherwise>
                            <input type="button" value="답글" class="btn" onclick="goTOReply()">
                        </c:otherwise>
                    </c:choose>
                </c:if>
                <input type="button" value="글목록" class="btn" onclick="location.href='freeBoardList.do'"></div>
            <div class="clear"></div>

    </article>



    <div class="clear"></div>
    <!-- 푸터가 들어가는 곳 -->
    <%@ include file="../../include/footer.jsp"%>

</div><!--warp 끝나는 부분-->
</body>
</html>
