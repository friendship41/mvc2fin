package mvc2.jsp.action;

import mvc2.jsp.model.MemberDAO;
import mvc2.jsp.model.MemberVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IdCheckAction implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        request.setCharacterEncoding("utf-8");

        String formId = request.getParameter("id");

        MemberDAO memberDAO = MemberDAO.getInstance();
        MemberVO memberVO = memberDAO.selectSingle(formId);
        if(memberVO == null || memberVO.getId() == null || memberVO.getId().equals(""))
        {
            request.setAttribute("msg", "사용가능한 아이디 입니다.");
        }
        else
        {
            request.setAttribute("msg", "중복된 아이디입니다.");
        }

        return "member/join/idCheck.jsp";
    }
}
