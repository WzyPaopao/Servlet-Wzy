package com.wzy.wzy_shop.controller;

import com.wzy.wzy_shop.entity.Vip;
import com.wzy.wzy_shop.service.VipService;
import com.wzy.wzy_shop.service.impl.VipServiceImpl;
import com.wzy.wzy_shop.util.PatternUtil;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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

        // 处理文件
        Part profile = request.getPart("profile");
        InputStream inputStream = profile.getInputStream();
        String fileName = profile.getSubmittedFileName();
        OutputStream outputStream = new FileOutputStream("F:\\tmp\\JavaProjects\\wzy-shop-upload\\" + fileName);
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buf)) != -1) {
            outputStream.write(buf, 0, len);
        }
        inputStream.close();
        outputStream.flush();
        outputStream.close();

        vip.setProfile(fileName);

        int res = vipService.register(vip);
        if (res > 0) {
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/fail.jsp").forward(request, response);
        }
    }
}
