package org.example.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.example.Resources.PAGE_LOGIN;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        // Ваша релизация фильтра входа пользователя на сайт

//
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpSession session = httpServletRequest.getSession(false);
//
//        boolean isLoggedIn = (session != null && session.getAttribute("usernameLogin") != null);
//
//        if (!isLoggedIn) {
//            httpServletRequest.getRequestDispatcher(PAGE_LOGIN).forward(request, response);
//            return;
//        }
//
//        filterChain.doFilter(request, response);
//    }


        if (true) { // Проверка, что пользователь авторизован (необходимо реализовать!!!)
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            httpServletRequest.getRequestDispatcher(PAGE_LOGIN).forward(request, response);
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
