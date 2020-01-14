package mvc2.jsp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login2Action implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        return "member/login/login2.jsp";
    }
}
