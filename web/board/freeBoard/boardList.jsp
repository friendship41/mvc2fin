<%--
  Created by IntelliJ IDEA.
  User: stage41
  Date: 2020-01-14
  Time: 오후 1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/default.css" />
    <script type="text/javascript" src="js/script.js"></script>
    <title>자유게시판</title>
      <script>
        function goToBoard_read(trObj) {
          var url = "/jsp_homepage1/board1/board_read.jsp?no="+trObj.id;
          console.log(trObj.id);
          location.href=url;
        }
        // function popupLoad() {
        //   notShowPop = getCookieValue();
        //   if(notShowPop != "true")
        //   {
        //     window.open("popup/popup1.jsp","pop","width=400,height=500,history=no,resizable=no,status=no,scrollbars=yes,menubar=no");
        //   }
        // }
        // function getCookieValue() {
        //   var result = "false";
        //   if(document.cookie != "")
        //   {
        //     cookie = document.cookie.split(";");
        //     for(i=0; i<cookie.length; i++)
        //     {
        //       element = cookie[i].split("=");
        //       value=element[0];
        //       value=value.replace(/^\s*/,'');
        //       if(value === "notShowPop")
        //       {
        //         result=element[1];
        //       }
        //     }
        //     return result;
        //   }
        //   function deleteCookie() {
        //     document.cookie = "notShowPop="+"false"+";path=/;expires=-1";
        //   }
        // }
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
        <h1>Board</h1>
        <c:if test="${sessionScope.id ne null}">
            <input type="button" value="write" class="btn" onclick="location.href='freeBoardWrite.do'"/>
        </c:if>
            <table id="board">
              <tr>
                <th class="tno">NO.</th>
                <th class="twriter">Writer</th>
                <th class="ttitle">Title</th>
                <th class="tread">Read</th>
                <th class="tdate">Date</th>
              </tr>
                <c:forEach var="arti" items="${requestScope.freeBoardList}">
                    <tr id="${arti.no}" onclick="javascript:goToBoard_read(this)">
                        <td>${arti.no}</td>
                        <td>${arti.writer}</td>
                        <td class="left">${arti.subject}</td>
                        <td>${arti.readcnt}</td>
                        <td>${arti.regdate}</td>
                    </tr>
                </c:forEach>

            </table>

            <form method="post" name="find_frm" action="/jsp_homepage1/index.jsp" onsubmit="return check()">
              <div id="table_search">
                <select class="select_box" name="find" size="1">
                  <option value="writer">이름</option>
                  <option value="subject">제목</option>
                  <option value="content">내용</option>
                </select>
                <input type="text" class="input_box" name="find_box" />
                <input type="submit" value="search" class="btn" />
              </div>
            </form>

        <div class="clear"></div>



            <div id="page_control">
                <c:if test="${requestScope.prev ne null}">
                    <a href="${requestScope.prev}">Prev</a>
                </c:if>
                <c:forEach var="i" begin="${requestScope.startBlockNo}" end="${requestScope.endBlockNo}" step="1">
                    <c:if test="${requestScope.nowPage eq i}">
                        <a><b>${i}</b></a>
                    </c:if>
                    <c:if test="${requestScope.nowPage ne i}">
                        <a href="freeBoardList.do?nowPage=${i}">${i}</a>
                    </c:if>
                </c:forEach>
                <c:if test="${requestScope.next ne null}">
                    <a href="${requestScope.next}">Next</a>
                </c:if>
            </div>
    </article>



    <div class="clear"></div>
    <!-- 푸터가 들어가는 곳 -->
    <%@ include file="../../include/footer.jsp"%>


</div><!--warp 끝나는 부분-->
</body>
</html>
