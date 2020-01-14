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

public class MemberDAO
{
    private MemberDAO()
    {}

    private static MemberDAO memberDAO;

    public static MemberDAO getInstance()
    {
        if(memberDAO == null)
        {
            synchronized (MemberDAO.class)
            {
                memberDAO = new MemberDAO();
            }
        }
        return memberDAO;
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

    public String selectPw(String id)
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            con = this.getConnection();

            String sql = "SELECT PW FROM JAVALINE_MEMBER WHERE ID=?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if(rs.next())
            {
                return rs.getString("PW");
            }
            else
            {
                return null;
            }
        }
        catch (SQLException e)
        {
            System.out.println("MemberDAO/selectPw: "+e.getMessage());
            return null;
        }
        finally
        {
            this.disConnect(con,pstmt,rs);
        }
    }

    public boolean insertMember(MemberVO memberVO)
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            con = this.getConnection();

            String sql = "insert into javaline_member values(?,?,?,?,?,?,?,?,?,?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberVO.getId());
            pstmt.setString(2, memberVO.getPw());
            pstmt.setString(3, memberVO.getName());
            pstmt.setString(4, memberVO.getTel1());
            pstmt.setString(5, memberVO.getTel2());
            pstmt.setString(6, memberVO.getTel3());
            pstmt.setString(7, memberVO.getEmail());
            pstmt.setString(8, memberVO.getPostcode());
            pstmt.setString(9, memberVO.getAddress1());
            pstmt.setString(10, memberVO.getAddress2());
            int result = pstmt.executeUpdate();

            if(result == 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        catch (SQLException e)
        {
            System.out.println("MemberDAO/insertMember: "+e.getMessage());
            return false;
        }
        finally
        {
            this.disConnect(con,pstmt,rs);
        }
    }

    public void deleteMember(String id)
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            con = this.getConnection();

            String sql = "DELETE JAVALINE_MEMBER WHERE ID = ?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            int result = pstmt.executeUpdate();

        }
        catch (SQLException e)
        {
            System.out.println("MemberDAO/deleteMember: "+e.getMessage());
        }
        finally
        {
            this.disConnect(con,pstmt,rs);
        }
    }


    public MemberVO selectSingle(String id)
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            con = this.getConnection();

            String sql = "SELECT * FROM JAVALINE_MEMBER WHERE ID=?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if(rs.next())
            {
                MemberVO memberVO = new MemberVO();
                memberVO.setId(id);
                memberVO.setName(rs.getString("NAME"));
                memberVO.setTel1(rs.getString("PHONE1"));
                memberVO.setTel2(rs.getString("PHONE2"));
                memberVO.setTel3(rs.getString("PHONE3"));
                memberVO.setEmail(rs.getString("EMAIL"));
                memberVO.setPostcode(rs.getString("ZIPCODE"));
                memberVO.setAddress1(rs.getString("ADDRESS1"));
                memberVO.setAddress2(rs.getString("ADDRESS2"));
                return memberVO;
            }
            else
            {
                return null;
            }
        }
        catch (SQLException e)
        {
            System.out.println("MemberDAO/selectPw: "+e.getMessage());
            return null;
        }
        finally
        {
            this.disConnect(con,pstmt,rs);
        }
    }


    public boolean updateMember(MemberVO memberVO)
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            con = this.getConnection();

            String sql1 = "UPDATE JAVALINE_MEMBER SET phone1=?, PHONE2=?, phone3=?, email=?, zipcode=?, address1=?, address2=? WHERE ID=?";
            String sql2 = "UPDATE JAVALINE_MEMBER SET pw=?, phone1=?, PHONE2=?, phone3=?, email=?, zipcode=?, address1=?, address2=? WHERE ID=?";
            String pw = memberVO.getPw();
            if(pw == null || pw.equals(""))
            {
                pstmt = con.prepareStatement(sql1);
                pstmt.setString(1, memberVO.getTel1());
                pstmt.setString(2, memberVO.getTel2());
                pstmt.setString(3, memberVO.getTel3());
                pstmt.setString(4, memberVO.getEmail());
                pstmt.setString(5, memberVO.getPostcode());
                pstmt.setString(6, memberVO.getAddress1());
                pstmt.setString(7, memberVO.getAddress2());
                pstmt.setString(8, memberVO.getId());
            }
            else
            {
                pstmt = con.prepareStatement(sql2);
                pstmt.setString(1, memberVO.getPw());
                pstmt.setString(2, memberVO.getTel1());
                pstmt.setString(3, memberVO.getTel2());
                pstmt.setString(4, memberVO.getTel3());
                pstmt.setString(5, memberVO.getEmail());
                pstmt.setString(6, memberVO.getPostcode());
                pstmt.setString(7, memberVO.getAddress1());
                pstmt.setString(8, memberVO.getAddress2());
                pstmt.setString(9, memberVO.getId());
            }

            int result = pstmt.executeUpdate();

            if(result == 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        catch (SQLException e)
        {
            System.out.println("MemberDAO/updateMember: "+e.getMessage());
            return false;
        }
        finally
        {
            this.disConnect(con,pstmt,rs);
        }
    }


    public String selectEmail(String id)
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            con = this.getConnection();

            String sql = "SELECT email FROM JAVALINE_MEMBER WHERE ID=?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if(rs.next())
            {
                return rs.getString("EMAIL");
            }
            else
            {
                return null;
            }
        }
        catch (SQLException e)
        {
            System.out.println("MemberDAO/selectEmail: "+e.getMessage());
            return null;
        }
        finally
        {
            this.disConnect(con,pstmt,rs);
        }
    }


    public List<String> selectIds(String email)
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<String> list = new ArrayList<>();

        try
        {
            con = this.getConnection();

            String sql = "SELECT ID FROM JAVALINE_MEMBER WHERE EMAIL=?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            while(rs.next())
            {
                list.add(rs.getString("ID"));
            }
            return list;
        }
        catch (SQLException e)
        {
            System.out.println("MemberDAO/selectIds: "+e.getMessage());
            return null;
        }
        finally
        {
            this.disConnect(con,pstmt,rs);
        }
    }


    public boolean updatePw(String id, String pw)
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            con = this.getConnection();

            String sql = "UPDATE JAVALINE_MEMBER SET PW=? WHERE ID=?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, pw);
            pstmt.setString(2, id);
            int result = pstmt.executeUpdate();

            if(result > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException e)
        {
            System.out.println("MemberDAO/updatePw: "+e.getMessage());
            return false;
        }
        finally
        {
            this.disConnect(con,pstmt,rs);
        }
    }


}
