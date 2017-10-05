package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import service_class.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service_class.User;

/**
 *
 * @author Administrator
 */
public class LoginServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        Cookie[] cookies = request.getCookies();
        String cookieName = "userCookie";
        HttpSession session = request.getSession();
        
        if (request.getParameter("action") != null)
        {
            for (Cookie cookie : cookies)
            {
                if (cookieName.equals(cookie.getName()))
                {
                    request.setAttribute("username", cookie.getValue());
                }
            }
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            session.invalidate();

        } else if (session.getAttribute("loggedInUsername") != null)
        {
            response.sendRedirect("home");
        } else if (cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                if (cookieName.equals(cookie.getName()))
                {
                    request.setAttribute("username", cookie.getValue());
                }
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }

        } else
        {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String url = "";
        String message = "";

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(username, password);

        if (user.getUsername().equals("") || user.getPassword().equals(""))
        {
            message = "Both values required!";

            request.setAttribute("username", user.getUsername());
            request.setAttribute("password", user.getPassword());
            request.setAttribute("errorMessage", message);
 
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else
        {
            UserService userService = new UserService();
            User temp = userService.login(username, password);

            try
            {
                if (!temp.equals(null))
                {
                    HttpSession session = request.getSession();

                    session.setAttribute("loggedInUsername", user.getUsername());
                    session.setAttribute("password", "");

                    if (request.getParameter("rememberMe") == null)
                    {
                        //checkbox not checked
                        Cookie[] cookies = request.getCookies();

                        for (Cookie cookie : cookies)
                        {
                            cookie.setMaxAge(0); //deletes the cookie
                            cookie.setPath("/"); //allow the download app to access the cookie
                            cookie.setValue(null);
                       
                            response.addCookie(cookie);
                        }

                    } else
                    {
                        //checkbox checked
                        Cookie cookie = new Cookie("userCookie", username);
                        cookie.setMaxAge(60 * 60 * 24 * 365 * 2); //cookie last 2 years
                        cookie.setPath("/"); //alows cookie access by entire app
                        response.addCookie(cookie);

                    }
                    response.sendRedirect("home");

                }

            } catch (NullPointerException e)
            {
                message = "Invalid User Or Password Try Again";

                request.setAttribute("username", user.getUsername());
                request.setAttribute("password", user.getPassword());
                request.setAttribute("errorMessage", message);
               
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }

        }

    }
}
