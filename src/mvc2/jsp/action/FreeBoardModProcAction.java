package mvc2.jsp.action;

import mvc2.jsp.model.BoardDAO;
import mvc2.jsp.model.BoardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FreeBoardModProcAction implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        request.setCharacterEncoding("utf-8");

        String no = request.getParameter("no");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        String ip = request.getParameter("ip");

        BoardVO boardVO = new BoardVO();
        boardVO.setNo(Integer.parseInt(no));
        boardVO.setSubject(subject);
        boardVO.setContent(content);
        boardVO.setIp(ip);

        BoardDAO boardDAO = BoardDAO.getInstance();
        boardDAO.updateSingleBoard(boardVO);

        return "freeBoardRead.do?no="+no;
    }
}
