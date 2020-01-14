package mvc2.jsp.action;

import mvc2.jsp.model.MemberDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginProcAction implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        request.setCharacterEncoding("utf-8");

        String url="";

        String formId = request.getParameter("id");
        String formPw = request.getParameter("pw");

        MemberDAO memberDAO = MemberDAO.getInstance();
        String dbPw = memberDAO.selectPw(formId);

        if(dbPw == null)
        {
            request.setAttribute("msg", "없는 아이디 입니다");
            url = "member/login/login.jsp";
        }
        else
        {
            if(formPw.equals(dbPw))
            {
                HttpSession session = request.getSession();
                session.setAttribute("id", formId);

                request.setAttribute("msg", "로그인 성공!");
                url = "member/login/login2.jsp";
            }
            else
            {
                request.setAttribute("msg", "잘못된 비밀번호 입니다");
                url = "member/login/login.jsp";
            }
        }

        return url;
    }
}
