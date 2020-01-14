package mvc2.jsp.action;

import mvc2.jsp.model.BoardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FreeBoardDeleteAction implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int no = Integer.parseInt(request.getParameter("no"));

        BoardDAO boardDAO = BoardDAO.getInstance();
        boardDAO.deleteSingleBoard(no);

        return "freeBoardList.do";
    }
}
