package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static servlet.LoginServlet.parameter;
import static servlet.LoginServlet.port;
import static servlet.LoginServlet.scheme;
import static servlet.LoginServlet.serverName;
import static servlet.LoginServlet.uri;


public class HomeServlet extends HttpServlet
{

    public static String scheme1;
    public static String serverName1;
    public static String port1;
    public static String uri1;
    public static String parameter1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        scheme = request.getScheme() + "://"; //http address
        serverName = request.getServerName(); 
        port = ":" + request.getServerPort(); //port of server
        uri = request.getRequestURI();        
        parameter = request.getQueryString() != null ? "?" + request.getQueryString() : ""; 

        HttpSession session = request.getSession();
        String nameOfUser = (String) session.getAttribute("loggedInUsername");
        if (nameOfUser == null)
        {
            response.sendRedirect("login");
        } else
        {
            request.setAttribute("loggedInUsername", nameOfUser);
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }

}
