package mvc2.jsp.controller;

import mvc2.jsp.action.Action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

@WebServlet(name = "MainController")
public class MainController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    private Map<String, Object> commandMap = new HashMap<>();

    @Override
    public void init() throws ServletException
    {
        String propName = getServletConfig().getInitParameter("propertyConfig");
        Properties prop = new Properties();
        String rootPath = getServletConfig().getServletContext().getRealPath("/WEB-INF");
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(new File(rootPath, propName));
            prop.load(fis);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (fis != null)
                try
                {
                    fis.close();
                }
                catch (IOException ioe)
                {
                }
        }

        Iterator<Object> propIter = prop.keySet().iterator();
        while(propIter.hasNext())
        {
            String actionURL = (String) propIter.next();
            try
            {
                Class actionClass = Class.forName(prop.getProperty(actionURL));
                Object actionInstance = actionClass.newInstance();
                commandMap.put(actionURL,actionInstance);
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
            catch (InstantiationException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String view = null;
        Action action = null;

        try
        {
            String cmd = request.getRequestURI();
            if(cmd.indexOf(request.getContextPath()) == 0)
            {
                cmd = cmd.substring(request.getContextPath().length());
            }
//            System.out.println("MainController.commandMap: "+commandMap.toString());
            System.out.println("수신된 커멘드:"+cmd);
            action = (Action)commandMap.get(cmd);
            view = action.execute(request, response);
        }
        catch (Throwable throwable)
        {
            throw new ServletException(throwable);
        }

        request.setCharacterEncoding("utf-8");

        RequestDispatcher disp = request.getRequestDispatcher(view);
        disp.forward(request, response);
    }
}
