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

    <div class="clear"></div>

  </article>



  <div class="clear"></div>
  <!-- 푸터가 들어가는 곳 -->
  <%@ include file="include/footer.jsp"%>


</div><!--warp 끝나는 부분-->
</body>
</html>
