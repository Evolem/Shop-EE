package ru.ee.exampleServlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//привязка через аннотацию
@WebServlet(name = "FirstHttpServlet", urlPatterns = "hservlet/*")
public class FirstHttpServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    //example http://127.0.0.1:8080/ee1/hservlet/333?param1=11&param2=22
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Http Servlet Page</h1>");
        resp.getWriter().println("<p> getContextPath(): " + req.getContextPath() + "</p>"); //имя приложения (контекст)
        resp.getWriter().println("<p> getServletPath(): " + req.getServletPath()+ "</p>"); // url адресс страницы
        resp.getWriter().println("<p> Info path: " + req.getPathInfo()+ "</p>"); // значение после ../hservlet/***/
        resp.getWriter().println("<p> Query String: " + req.getQueryString()+ "</p>"); // получение параметров через ?param=***&param=*** ...

        //получение отдельных параметров из url
        resp.getWriter().println("<p> param1: " + req.getParameter("param1")+ "</p>");
        resp.getWriter().println("<p> param1: " + req.getParameter("param2")+ "</p>");

        resp.setHeader( "Content-Type" , "text/html; charset=utf-8" );
        req.setAttribute("MyAtr", "-hi-");



        // Редирект внутри сервера
        // getServletContext().getRequestDispatcher("/").forward(req,resp);
        // Задействуется браузер
        // resp.sendRedirect("https://ya.ru");
        // resp.sendRedirect(req.getContextPath() +"/");

        // Склейка контента
         getServletContext().getRequestDispatcher("/FirstServlet").include(req,resp); // + сервлет
         getServletContext().getRequestDispatcher("/WEB-INF/private.jsp").include(req,resp); // + private.jsp
    }
}
