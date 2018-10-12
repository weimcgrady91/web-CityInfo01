package com.wei.cityinfo.filter;

import com.wei.cityinfo.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

//        System.out.println("request uri="+req.getRequestURI());
//        System.out.println("request url=" + req.getRequestURL());
//        System.out.println("request scheme=" + req.getScheme());
//        System.out.println("request servletPath=" + req.getServletPath());
//        System.out.println("request serverName=" + req.getServerName());
//        System.out.println("request serverPort=" + req.getServerPort());
//        System.out.println("request serverContext=" + req.getContextPath());
        String servletPath = req.getServletPath();
        if (servletPath.contains("admin") && !servletPath.equals("/admin/login")) {
            HttpSession session = req.getSession(true);
            User user = (User) session.getAttribute("admin");
            if (user == null) {
//                req.getRequestDispatcher("/admin/login").forward(req, resp);
                resp.sendRedirect("login");
            } else {
                filterChain.doFilter(req,resp);
            }
        } else {
            filterChain.doFilter(req, resp);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
