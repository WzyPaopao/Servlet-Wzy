package com.wzy.wzy_shop.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CharsetFilter")
public class CharsetFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpServletResponse r = (HttpServletResponse) response;
        r.addHeader("content-type", "text/html; charset=UTF-8");

        chain.doFilter(request, r);

//        HttpServletResponse r = (HttpServletResponse) response;
//        if (r.getHeader("content-type") == null) {
//            r.addHeader("content-type", "text/html;charset=utf-8");
//        }
    }
}
