<nav id="sub_menu">
    <ul>
        <c:if test="${sessionScope.id eq null}">
            <li><a href="login.do">Login</a></li>
            <li><a href="join.do">Join Us</a></li>
        </c:if>
        <c:if test="${sessionScope.id ne null}">
            <li><a href="logoutProc.do">Logout</a></li>
        </c:if>
        <li><a href="/mvc2">Board</a></li>
        <li><a href="#">Ajax Board</a></li>
    </ul>
</nav>
