package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static servlet.LoginServlet.parameter;
import static servlet.LoginServlet.port;
import static servlet.LoginServlet.scheme;
import static servlet.LoginServlet.serverName;
import static servlet.LoginServlet.uri;

/**
 *
 * @author Administrator
 */
@WebServlet(urlPatterns =
{
    "/HomeServlet"
})
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
        scheme = request.getScheme() + "://"; //http://
        serverName = request.getServerName(); //example
        port = ":" + request.getServerPort(); //:8080
        uri = request.getRequestURI();        //people
        parameter = request.getQueryString() != null ? "?" + request.getQueryString() : ""; // "?" + "lastname=Fox&age=30"

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
