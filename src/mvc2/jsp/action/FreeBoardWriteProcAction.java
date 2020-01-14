package mvc2.jsp.action;

import mvc2.jsp.model.BoardDAO;
import mvc2.jsp.model.BoardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FreeBoardWriteProcAction implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("wname");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        String ip = request.getParameter("ip");

        BoardVO boardVO = new BoardVO();
        boardVO.setWriter(name);
        boardVO.setEmail(email);
        boardVO.setSubject(subject);
        boardVO.setContent(content);
        boardVO.setIp(ip);


        BoardDAO boardDAO = BoardDAO.getInstance();
        boardDAO.insertNewBoard(boardVO);


        return "freeBoardList.do";
    }
}
