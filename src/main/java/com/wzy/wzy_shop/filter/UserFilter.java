package com.wzy.wzy_shop.filter;

import com.wzy.wzy_shop.entity.Vip;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest) request;

        List<String> whiteNames = new ArrayList<>();
        whiteNames.add("/shop/login.jsp");
        whiteNames.add("/shop/register.jsp");
        if (whiteNames.contains(request1.getRequestURI())) {
            chain.doFilter(request, response);
        }

        HttpServletResponse response1 = (HttpServletResponse) response;
        HttpSession session = request1.getSession();
        Vip vip = (Vip) session.getAttribute("user");
        if (vip == null) {
            response1.sendRedirect(request1.getContextPath() + "/login.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }
}
