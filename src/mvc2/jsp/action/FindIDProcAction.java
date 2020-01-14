package mvc2.jsp.action;

import mvc2.jsp.model.MemberDAO;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class FindIDProcAction implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        request.setCharacterEncoding("utf-8");

        String email = request.getParameter("email");

        int random = (int)Math.floor((Math.random()*(99999-10000+1)))+10000;

        MemberDAO memberDAO = MemberDAO.getInstance();
        List<String> idList = memberDAO.selectIds(email);

        String url = null;

        if(idList.size() == 0)
        {
            request.setAttribute("msg","가입되지 않은 이메일입니다...");
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

                msg.setText("인정번호 코드: "+random, "UTF-8");

                msg.setHeader("content-Type", "text/html");

                Transport.send(msg);
            }
            catch (MessagingException e)
            {
                e.printStackTrace();
            }

            System.out.println("MailToU-code: "+random);
            request.setAttribute("code", random+"");
            request.setAttribute("email", email);

            url="member/login/checkCodeId.jsp";
        }

        return url;
    }


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
