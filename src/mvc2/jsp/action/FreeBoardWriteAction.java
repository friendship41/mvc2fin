package mvc2.jsp.action;

import mvc2.jsp.model.MemberDAO;
import mvc2.jsp.model.MemberVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FreeBoardWriteAction implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        if(id == null || id.equals(""))
        {
            return "login.do";
        }

        MemberDAO memberDAO = MemberDAO.getInstance();
        MemberVO memberVO = memberDAO.selectSingle(id);
        request.setAttribute("myInfo", memberVO);

        return "board/freeBoard/writeBoard.jsp";
    }
}
