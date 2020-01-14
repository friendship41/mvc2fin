package mvc2.jsp.action;

import mvc2.jsp.model.MemberDAO;
import mvc2.jsp.model.MemberVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class JoinProcAction implements Action
{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String tel1 = request.getParameter("tel1");
        String tel2 = request.getParameter("tel2");
        String tel3 = request.getParameter("tel3");
        String postcode = request.getParameter("postcode");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");

        MemberVO memberVO = new MemberVO();
        memberVO.setId(id);
        memberVO.setPw(pw);
        memberVO.setName(name);
        memberVO.setEmail(email);
        memberVO.setTel1(tel1);
        memberVO.setTel2(tel2);
        memberVO.setTel3(tel3);
        memberVO.setPostcode(postcode);
        memberVO.setAddress1(address1);
        memberVO.setAddress2(address2);

        MemberDAO memberDAO = MemberDAO.getInstance();
        boolean result = memberDAO.insertMember(memberVO);

        if(result)
        {
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
        }

        return "login.do";
    }
}
