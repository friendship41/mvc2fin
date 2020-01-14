package mvc2.jsp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutProcAction implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        HttpSession session = request.getSession();
        session.setAttribute("id", null);

        return "index.do";
    }
}
