package mvc2.jsp.action;

import mvc2.jsp.model.MemberDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberDeleteProcAction implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");

        String formPw = request.getParameter("pw");

        MemberDAO memberDAO = MemberDAO.getInstance();
        String dbPw = memberDAO.selectPw(id);

        session.setAttribute("id", null);
        if(formPw.equals(dbPw))
        {
            memberDAO.deleteMember(id);
            request.setAttribute("msg", "정상적으로 탈퇴되었습니다. 안녕히가세요...");
        }
        else
        {
            request.setAttribute("msg", "잘못된 비밀번호입니다. 다시 로그인 해주세요.");
        }

        return "login.do";
    }
}
