package com.wzy.wzy_shop.controller;

import com.wzy.wzy_shop.entity.Vip;
import com.wzy.wzy_shop.service.VipService;
import com.wzy.wzy_shop.service.impl.VipServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class LoginServlet extends HttpServlet {
    private VipService vipService = new VipServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vip vip = new Vip();
        vip.setUsername(request.getParameter("username"));
        vip.setPassword(request.getParameter("password"));
        boolean loginFlag = vipService.login(vip);

        if (!loginFlag) {
            request.getRequestDispatcher("/fail.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("username", vip.getUsername());
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        }
    }
}
