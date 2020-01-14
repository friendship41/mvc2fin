<%--
  Created by IntelliJ IDEA.
  User: stage41
  Date: 2020-01-14
  Time: 오전 9:27
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
  <title>메인페이지</title>
  <%--  <script>--%>
  <%--    function goToBoard_read(trObj) {--%>
  <%--      var url = "/jsp_homepage1/board1/board_read.jsp?no="+trObj.id;--%>
  <%--      console.log(trObj.id);--%>
  <%--      location.href=url;--%>
  <%--    }--%>
  <%--    function popupLoad() {--%>
  <%--      notShowPop = getCookieValue();--%>
  <%--      if(notShowPop != "true")--%>
  <%--      {--%>
  <%--        window.open("popup/popup1.jsp","pop","width=400,height=500,history=no,resizable=no,status=no,scrollbars=yes,menubar=no");--%>
  <%--      }--%>
  <%--    }--%>
  <%--    function getCookieValue() {--%>
  <%--      var result = "false";--%>
  <%--      if(document.cookie != "")--%>
  <%--      {--%>
  <%--        cookie = document.cookie.split(";");--%>
  <%--        for(i=0; i<cookie.length; i++)--%>
  <%--        {--%>
  <%--          element = cookie[i].split("=");--%>
  <%--          value=element[0];--%>
  <%--          value=value.replace(/^\s*/,'');--%>
  <%--          if(value === "notShowPop")--%>
  <%--          {--%>
  <%--            result=element[1];--%>
  <%--          }--%>
  <%--        }--%>
  <%--        return result;--%>
  <%--      }--%>
  <%--      function deleteCookie() {--%>
  <%--        document.cookie = "notShowPop="+"false"+";path=/;expires=-1";--%>
  <%--      }--%>
  <%--    }--%>
  <%--  </script>--%>
</head>
<body>
<div id="warp">
  <!--헤더파일 들어가는 곳-->
  <%@ include file="include/header.jsp"%>

  <!--그림파일 들어가는 곳 없어도 되지만 한번 넣어보자-->
  <div id="sub_img">
  </div>
  <!--왼쪽의 서브메뉴가 들어가는 곳-->
  <%@ include file="include/left.jsp"%>

  <!--실제 내용 콘텐츠가 들어가는 곳-->
  <article id="contents">
    <h1>Board</h1>
    <c:if test="${id ne null}">
      <input type="button" value="write" class="btn" onclick="location.href='/jsp_homepage1/board1/writeBoard1.jsp'"/>
    </c:if>
    <%--    <table id="board">--%>
    <%--      <tr>--%>
    <%--        <th class="tno">NO.</th>--%>
    <%--        <th class="twriter">Writer</th>--%>
    <%--        <th class="ttitle">Title</th>--%>
    <%--        <th class="tread">Read</th>--%>
    <%--        <th class="tdate">Date</th>--%>
    <%--      </tr>--%>
    <%--      <%--%>
    <%--        int boardCnt = -1;--%>
    <%--        String searchType = "";--%>
    <%--        if(searchWord == null || searchWord.equals(""))--%>
    <%--        {--%>
    <%--          boardCnt = board1DAO.selectBoardCount();--%>
    <%--        }--%>
    <%--        else--%>
    <%--        {--%>
    <%--          searchType = request.getParameter("find");--%>
    <%--          boardCnt = board1DAO.selectSearchBoardCount(searchType, searchWord);--%>
    <%--        }--%>
    <%--        if(nowPage == null)--%>
    <%--        {--%>
    <%--          nowPage = "1";--%>
    <%--        }--%>
    <%--        int nowPageInt = 0;--%>
    <%--        try--%>
    <%--        {--%>
    <%--          nowPageInt = Integer.parseInt(nowPage);--%>
    <%--        }--%>
    <%--        catch (NumberFormatException e)--%>
    <%--        {--%>
    <%--          e.printStackTrace();--%>
    <%--        }--%>
    <%--        int startNo = pageCnt*(nowPageInt-1)+1;--%>
    <%--        int endNo = pageCnt*nowPageInt;--%>

    <%--        List<Board1VO> board1List = null;--%>
    <%--        if(searchWord == null || searchWord.equals(""))--%>
    <%--        {--%>
    <%--          board1List = board1DAO.selectAllBoardList(startNo, endNo);--%>
    <%--        }--%>
    <%--        else--%>
    <%--        {--%>
    <%--          board1List = board1DAO.selectSearchedBoardList(startNo, endNo, searchType, searchWord);--%>
    <%--        }--%>

    <%--        for(Board1VO art : board1List){%>--%>
    <%--      <tr id="<%=art.getNo()%>" onclick="javascript:goToBoard_read(this)">--%>
    <%--        <td><%=art.getNo()%></td>--%>
    <%--        <td><%=art.getWriter()%></td>--%>
    <%--        <td class="left"><%=art.getSubject()%></td>--%>
    <%--        <td><%=art.getReadcnt()%></td>--%>
    <%--        <td><%=art.getRegdate()%></td>--%>
    <%--      </tr>--%>
    <%--      <%}%>--%>
    <%--    </table>--%>

    <%--    <form method="post" name="find_frm" action="/jsp_homepage1/index.jsp" onsubmit="return check()">--%>
    <%--      <div id="table_search">--%>
    <%--        <select class="select_box" name="find" size="1">--%>
    <%--          <option value="writer">이름</option>--%>
    <%--          <option value="subject">제목</option>--%>
    <%--          <option value="content">내용</option>--%>
    <%--        </select>--%>
    <%--        <input type="text" class="input_box" name="find_box" />--%>
    <%--        <input type="submit" value="search" class="btn" />--%>
    <%--      </div>--%>
    <%--    </form>--%>

    <div class="clear"></div>



    <%--    <div id="page_control">--%>
    <%--      <% if(nowPageInt > blockCnt) {--%>
    <%--        String prev = urlNum + (startBlockNum-1);%>--%>
    <%--      <a href="<%=prev%>">Prev</a>--%>
    <%--      <%}--%>
    <%--        for(int i=startBlockNum; i<=endBlockNum; i++){--%>
    <%--          String goPage = urlNum+i;%>--%>
    <%--      <% if(nowPageInt==i){ %>--%>
    <%--      <a href="<%=goPage%>"><b><%=i%></b></a>--%>
    <%--      <%}--%>
    <%--      else--%>
    <%--      {%>--%>
    <%--      <a href="<%=goPage%>"><%=i%></a>--%>
    <%--      <%}--%>
    <%--      }%>--%>
    <%--      <% if(endBlockNum != pageAllNum) {--%>
    <%--        String next = urlNum + (endBlockNum+1);%>--%>
    <%--      <a href="<%=next%>">Next</a>--%>
    <%--      <%}%>--%>
    <%--    </div>--%>

  </article>



  <div class="clear"></div>
  <!-- 푸터가 들어가는 곳 -->
  <%@ include file="include/footer.jsp"%>


</div><!--warp 끝나는 부분-->
</body>
</html>
