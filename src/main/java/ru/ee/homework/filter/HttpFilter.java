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
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html");
        filterConfig.getServletContext().getRequestDispatcher("/templates/header.jsp").include(servletRequest,servletResponse);
        filterChain.doFilter(servletRequest, servletResponse);
        filterConfig.getServletContext().getRequestDispatcher("/templates/footer.jsp").include(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
