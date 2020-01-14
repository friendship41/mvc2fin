<%--
  Created by IntelliJ IDEA.
  User: stage41
  Date: 2020-01-13
  Time: 오후 1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/mvc2/css/join_us.css" />
    <script type="text/javascript" src="/mvc2/js/script.js"></script>
    <title>회원가입</title>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
        <h1>Join Us</h1>
        <form name="join" id="join" method="post" action="joinProc.do">
            <fieldset><legend>Basic Infomation</legend>
                <ul>
                    <li><label>User ID　</label><input type="text" id="id" name="id" class="id"/> <input type="button" value="중복체크" id="dup" class="btn" onclick="idCheck(this.form.id.value)"/></li>
                    <li><label>Password　</label><input type="password" id="pw" name="pw" class="pass"/></li>
                    <li><label>Retype Password　</label><input type="password" id="repw" class="pass"/></li>
                    <li><label>Name　</label><input type="text" id="name" name="name" class="nick"/></li>
                    <li><label>Email　</label><input type="text" id="email" name="email" class="email"/></li>

                </ul>
            </fieldset>
            <fieldset><legend>Optional</legend>
                <ul>
                    <li><label>Phone Number　</label>
                        <select name="tel1">
                            <option value="02">02</option>
                            <option value="010">010</option>
                            <option value="011">011</option>
                            <option value="016">016</option>
                            <option value="017">017</option>
                            <option value="018">018</option>
                            <option value="019">019</option>
                        </select>-
                        <input type="text" id="tel2" name="tel2" class="tel" maxlength="4" size="5"/>-
                        <input type="text" id="tel3" name="tel3" class="tel" maxlength="4" size="5"/></li>

                    <li><label>Postal Code　</label>
                        <input type="text" id="postcode" name="postcode" class="" readOnly/>
                        <input type="button" value="찾기" class="btn" onClick="sample6_execDaumPostcode()"/></li>
                    <li><label>Address1　</label>
                        <input type="text" id="address1" name="address1" class="address" readonly/></li>
                    <li><label>Address2　</label>
                        <input type="text" id="address2" name="address2" class="address"/></li>
                </ul>
            </fieldset>
            <div class="clear"></div>
            <div id="buttons">
                <input type="button" value="Submit" class="btn" onclick="checkJoinForm()">
                <input type="button" value="Cancel" id="cancel" class="btn" onclick="goToHome()">
            </div>
        </form>


    </article>
    <div class="clear"></div>
    <!-- 푸터가 들어가는 곳 -->
    <%@ include file="../../include/footer.jsp" %>

</div><!--warp 끝나는 부분-->
</body>
</html>
