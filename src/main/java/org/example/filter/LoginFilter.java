package org.example.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.example.Resources.COMMAND_SHOW_LOGIN_PAGE;
import static org.example.Resources.PAGE_LOGIN;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        boolean isChatPageRequest = "/chat".equals(httpRequest.getServletPath()) &&
                "show_chat_page".equals(httpRequest.getParameter("command"));

        boolean isLoggedIn = (session != null && session.getAttribute("loginInput") != null);

        if (isChatPageRequest && !isLoggedIn) {
            httpResponse.sendRedirect(COMMAND_SHOW_LOGIN_PAGE);
        }
        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {
    }
}
