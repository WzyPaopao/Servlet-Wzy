package com.wzy.wzy_shop.controller;

import com.wzy.wzy_shop.entity.Vip;
import com.wzy.wzy_shop.service.VipService;
import com.wzy.wzy_shop.service.impl.VipServiceImpl;
import com.wzy.wzy_shop.util.PatternUtil;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.IOException;

@MultipartConfig
public class VipServlet extends HttpServlet {
    private VipService vipService = new VipServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        boolean userLegal = PatternUtil.checkUserReg(username);
        if (!userLegal) {
            request.getRequestDispatcher("/fail.jsp").forward(request, response);
        }

        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        Vip vip = new Vip(username, password, gender);
        int res = vipService.register(vip);
        if (res > 0) {
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/fail.jsp").forward(request, response);
        }
    }
}
