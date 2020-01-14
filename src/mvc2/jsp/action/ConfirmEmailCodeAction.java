package mvc2.jsp.action;

import mvc2.jsp.model.MemberDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ConfirmEmailCodeAction implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        request.setCharacterEncoding("utf-8");

        String confirmCode = request.getParameter("confirmCode");
        String code = request.getParameter("code");
        String email = request.getParameter("email");

        String url = null;
        if(code.equals(confirmCode))
        {
            MemberDAO memberDAO = MemberDAO.getInstance();
            List<String> idList = memberDAO.selectIds(email);
            request.setAttribute("idList", idList);
            url = "member/login/showIds.jsp";
        }
        else
        {
            request.setAttribute("msg", "잘못된 인증번호 입니다. 처음부터 다시해주세요");
            url = "login.do";
        }

        return url;
    }
}
