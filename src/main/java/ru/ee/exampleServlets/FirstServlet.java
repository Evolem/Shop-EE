package ru.ee.exampleServlets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;


//привязка к url через web.xml
public class FirstServlet implements Servlet {
    Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    logger.info("new request");

    servletResponse.getWriter().println("<h1>FIRST SERVLET</h1>");
    servletResponse.getWriter().println("<P> MyAtr:" + servletRequest.getAttribute("MyAtr") + "</p>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
