package mvc2.jsp.action;

import mvc2.jsp.model.MemberDAO;
import mvc2.jsp.model.MemberVO;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Properties;

public class FindPWProcAction implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        request.setCharacterEncoding("utf-8");

        int random = (int)Math.floor((Math.random()*(99999-10000+1)))+10000;

        String id = request.getParameter("id");
        String email = request.getParameter("email");

        String url = null;

        MemberDAO memberDAO = MemberDAO.getInstance();
        MemberVO memberVO = memberDAO.selectSingle(id);
        if(memberVO == null)
        {
            request.setAttribute("msg", "없는 아이디 입니다");
            url = "findIDPW.do";
        }
        else
        {
            if(!memberVO.getEmail().equals(email))
            {
                request.setAttribute("msg", "가입된 이메일과 다릅니다..");
                url = "findIDPW.do";
            }
            else
            {
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.naver.com");
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");

                Authenticator auth = new MyAuthentication();

                Session session = Session.getDefaultInstance(props,auth);
                MimeMessage msg = new MimeMessage(session);

                try
                {
                    msg.setSentDate(new Date());

                    InternetAddress from = new InternetAddress("poo963369@naver.com");

                    msg.setFrom(from);


                    InternetAddress to = new InternetAddress(email);
                    msg.setRecipient(Message.RecipientType.TO, to);

                    msg.setSubject("비밀번호 인증번호", "UTF-8");

                    msg.setText("임시 비밀번호: "+random, "UTF-8");

                    msg.setHeader("content-Type", "text/html");

                    Transport.send(msg);
                }
                catch (MessagingException e)
                {
                    e.printStackTrace();
                }

                System.out.println("FindPWProcAction: "+random);

                memberDAO.updatePw(id, random+"");

                request.setAttribute("msg", "임시 비밀번호를 메일로 발송 했습니다.");
                url = "login.do";
            }

        }

        return url;
    }



    //    메일서버에 로그인정보 코드 부분
    class MyAuthentication extends Authenticator
    {
        PasswordAuthentication pa;

        public MyAuthentication(){
            String id = "poo963369";
            String pw = "####";     //비밀번호

            pa = new PasswordAuthentication(id, pw);
        }

        public PasswordAuthentication getPasswordAuthentication(){
            return pa;
        }
    }

}
