package mvc2.jsp.action;

import mvc2.jsp.model.BoardDAO;
import mvc2.jsp.model.BoardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FreeBoardModAction implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int no = Integer.parseInt(request.getParameter("no"));

        BoardDAO boardDAO = BoardDAO.getInstance();
        BoardVO boardVO = boardDAO.selectSingleBoard(no);
        request.setAttribute("boardVO", boardVO);

        return "board/freeBoard/boardMod.jsp";
    }
}
