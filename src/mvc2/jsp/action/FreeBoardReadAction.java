package mvc2.jsp.action;

import mvc2.jsp.model.BoardDAO;
import mvc2.jsp.model.BoardVO;
import mvc2.jsp.model.MemberDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FreeBoardReadAction implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int no = Integer.parseInt(request.getParameter("no"));

        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");

        BoardDAO boardDAO = BoardDAO.getInstance();
        boardDAO.updateReadCnt(no);
        BoardVO boardVO = boardDAO.selectSingleBoard(no);
        request.setAttribute("boardVO", boardVO);

        if(id != null && !id.equals(""))
        {
            MemberDAO memberDAO = MemberDAO.getInstance();
            String myName = memberDAO.selectSingle(id).getName();
            request.setAttribute("myName", myName);
        }


        return "board/freeBoard/boardRead.jsp";
    }
}
