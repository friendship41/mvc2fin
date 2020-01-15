package mvc2.jsp.action;

import mvc2.jsp.model.BoardDAO;
import mvc2.jsp.model.BoardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FreeBoardReplyAction implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        request.setCharacterEncoding("utf-8");

        int no = Integer.parseInt(request.getParameter("no"));
        String name = request.getParameter("wname");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        String ip = request.getParameter("ip");
        int ref = Integer.parseInt(request.getParameter("ref"));
        int step = Integer.parseInt(request.getParameter("step"));
        int depth = Integer.parseInt(request.getParameter("depth"));

        BoardVO boardVO = new BoardVO();
        boardVO.setNo(no);
        boardVO.setWriter(name);
        boardVO.setEmail(email);
        boardVO.setSubject(subject);
        boardVO.setContent(content);
        boardVO.setRef(ref);
        boardVO.setStep(step);
        boardVO.setDepth(depth);
        boardVO.setIp(ip);

        BoardDAO boardDAO = BoardDAO.getInstance();
        boardDAO.updateRefStepDepth(boardVO);
        boardDAO.insertReply(boardVO);


        return "freeBoardList.do";
    }
}
