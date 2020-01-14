package mvc2.jsp.action;

import mvc2.jsp.model.MemberDAO;
import mvc2.jsp.model.MemberVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberModAction implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");

        String url="";

        if(id != null || !id.equals(""))
        {
            MemberDAO memberDAO = MemberDAO.getInstance();
            MemberVO memberVO = memberDAO.selectSingle(id);

            request.setAttribute("memberVO", memberVO);
            url = "member/mod/memberMod.jsp";
        }
        else
        {
            request.setAttribute("msg", "로그인을 해주세요.");
            url = "login.do";
        }

        return url;
    }
}
