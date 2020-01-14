package mvc2.jsp.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO
{
    private BoardDAO()
    {}

    private static BoardDAO boardDAO;

    public static BoardDAO getInstance()
    {
        if(boardDAO == null)
        {
            synchronized (BoardDAO.class)
            {
                boardDAO = new BoardDAO();
            }
        }
        return boardDAO;
    }

    private Connection getConnection()
    {
        Connection con = null;
        try
        {
            Context init = new InitialContext();
            DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mvc2");
            con = ds.getConnection();
        }
        catch (NamingException | SQLException e)
        {
            e.printStackTrace();
            System.out.println("커넥션 받아오는 곳에서 오류");
        }
        return con;
    }

    private void disConnect(Connection con, PreparedStatement pstmt, ResultSet rs){
        try {if(rs!=null && !rs.isClosed()){rs.close();}} catch (SQLException e1) {}
        try {if(pstmt!=null && !pstmt.isClosed()){pstmt.close();}}catch (SQLException e) {}
        try {if(con!=null && !con.isClosed()){con.close();}}catch (SQLException e){}
    }



    public void insertNewBoard(BoardVO boardVO)
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            con = this.getConnection();

            String sql = "INSERT INTO JAVALINE_BOARD1 VALUES(JAVALINE_BOARD1__NO_SEQ.NEXTVAL, ?,?,?,0, (SELECT MAX(REF)+1 FROM JAVALINE_BOARD1), 0, 0, SYSDATE, ?, ?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, boardVO.getWriter());
            pstmt.setString(2, boardVO.getEmail());
            pstmt.setString(3, boardVO.getSubject());
            pstmt.setString(4, boardVO.getContent());
            pstmt.setString(5, boardVO.getIp());
            pstmt.executeUpdate();

        }
        catch (SQLException e)
        {
            System.out.println("BoardDAO/insertNewBoard: "+e.getMessage());
        }
        finally
        {
            this.disConnect(con,pstmt,rs);
        }
    }


    public int selectBoardCount()
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            con = this.getConnection();

            String sql = "SELECT COUNT(*) CNT FROM JAVALINE_BOARD1";

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            rs.next();
            return rs.getInt("CNT");
        }
        catch (SQLException e)
        {
            System.out.println("Board1DAO/selectBoardCount: "+e.getMessage());
            return -1;
        }
        finally
        {
            this.disConnect(con,pstmt,rs);
        }
    }


    public List<BoardVO> selectAllBoardList(int startNum, int endNum)
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<BoardVO> list = new ArrayList<>();

        try
        {
            con = this.getConnection();

            String sql = "SELECT * FROM (SELECT ROWNUM RN, NO, WRITER, EMAIL, SUBJECT, READCNT, REF, STEP, DEPTH, REGDATE, CONTENT, IP FROM (SELECT NO, WRITER, EMAIL, SUBJECT, READCNT, REF, STEP, DEPTH, TO_CHAR(REGDATE,'YYYY/MM/DD') REGDATE, CONTENT, IP FROM JAVALINE_BOARD1 ORDER BY REF DESC, STEP ASC)) WHERE RN>=? AND RN<=?";
//            String sql = "SELECT NO, WRITER, EMAIL, SUBJECT, READCNT, REF, STEP, DEPTH, TO_CHAR(REGDATE,'YYYY/MM/DD') REGDATE, CONTENT, IP FROM JAVALINE_BOARD1 ORDER BY REF DESC, STEP ASC";

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, startNum);
            pstmt.setInt(2, endNum);
            rs = pstmt.executeQuery();

            while (rs.next())
            {
                BoardVO boardVO = new BoardVO();
                boardVO.setNo(rs.getInt("NO"));
                boardVO.setWriter(rs.getString("WRITER"));
//                board1VO.setEmail(rs.getString("EMAIL"));
                boardVO.setSubject(rs.getString("SUBJECT"));
                boardVO.setReadcnt(rs.getInt("READCNT"));
                boardVO.setRef(rs.getInt("REF"));
                boardVO.setStep(rs.getInt("STEP"));
                boardVO.setDepth(rs.getInt("DEPTH"));
                boardVO.setRegdate(rs.getString("REGDATE"));
//                board1VO.setContent(rs.getString("CONTENT"));
//                board1VO.setIp(rs.getString("IP"));
                list.add(boardVO);
            }

            return list;

        }
        catch (SQLException e)
        {
            System.out.println("Board1DAO/selectAllBoardList: "+e.getMessage());
            return null;
        }
        finally
        {
            this.disConnect(con,pstmt,rs);
        }
    }



}
