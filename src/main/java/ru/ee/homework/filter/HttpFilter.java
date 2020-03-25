package ru.ee.homework.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "HeaderFooter", urlPatterns = "/*")
public class HttpFilter implements Filter {

    //для получения диспатчера и т.д
    FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig =filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=UTF-8");
        servletResponse.getWriter().println("<html><h3>HEADER</h3>"); //временные костыли ...
        filterConfig.getServletContext().getRequestDispatcher("/WEB-INF/menu.jsp").include(servletRequest,servletResponse);
        filterChain.doFilter(servletRequest, servletResponse);
        servletResponse.getWriter().println("<h3>FOOTER</h3></html>");
    }

    @Override
    public void destroy() {

    }
}
