package org.example.filter;


import org.example.data.User;
import org.example.data.UserType;

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
import java.util.HashMap;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.Resources.COMMAND_SHOW_LOGIN_PAGE;
import static org.example.data.DataBase.getUserMap;

public class BanFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpRequest.getSession(false);

        boolean isBanPageRequest = "/chat".equals(httpRequest.getServletPath())
                && "show_ban_page".equals(httpRequest.getParameter("command"));

        if (isBanPageRequest) {
            HashMap<String, User> userMap = getUserMap();
            String userLog = null;
            try {
                userLog = (String) session.getAttribute("loginInput");
            } catch (NullPointerException e) {
                System.out.println("Error");
            }

            if (userLog != null) {
                User sessionUser = userMap.get(userLog);
                if (sessionUser != null && sessionUser.getUserType() != UserType.ADMIN) {
                    httpResponse.sendRedirect(COMMAND_SHOW_CHAT_PAGE);
                    return;
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
    }
}
