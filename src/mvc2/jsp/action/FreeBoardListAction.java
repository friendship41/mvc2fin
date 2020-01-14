package mvc2.jsp.action;

import mvc2.jsp.model.BoardDAO;
import mvc2.jsp.model.BoardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FreeBoardListAction implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int pageSize = 5;
        int blockSize = 5;

        String tempNowPage = request.getParameter("nowPage");
        int nowPage = -1;
        if(tempNowPage == null || tempNowPage.equals(""))
        {
            nowPage = 1;
        }
        else
        {
            nowPage = Integer.parseInt(tempNowPage);
        }

        request.setAttribute("nowPage", ""+nowPage);


        BoardDAO boardDAO = BoardDAO.getInstance();

        int artiCnt = boardDAO.selectBoardCount();

        int startArtiNo = pageSize*(nowPage-1)+1;
        int endArtiNo =pageSize*nowPage;


        List<BoardVO> list = boardDAO.selectAllBoardList(startArtiNo, endArtiNo);

        request.setAttribute("freeBoardList", list);


        int temp = artiCnt%pageSize==0 ? 0:1;
        int blockCnt = (int)(artiCnt/pageSize)+temp;
        int startBlockNo = ((int)((nowPage-1)/blockSize))*blockSize+1;
        int endBlockNo = startBlockNo+blockSize-1;
        if(endBlockNo > blockCnt)
        {
            endBlockNo = blockCnt;
        }
        request.setAttribute("startBlockNo", startBlockNo);
        request.setAttribute("endBlockNo", endBlockNo);

        String tempURL;
        if(nowPage > blockSize)
        {
            tempURL = "freeBoardList.do?nowPage="+(startBlockNo-1);
            request.setAttribute("prev", tempURL);
        }
        else
        {
            request.setAttribute("prev", null);
        }
        if(endBlockNo != blockCnt)
        {
            tempURL = "freeBoardList.do?nowPage="+(endBlockNo+1);
            request.setAttribute("next", tempURL);
        }
        else
        {
            request.setAttribute("next", null);
        }


        return "board/freeBoard/boardList.jsp";
    }
}
