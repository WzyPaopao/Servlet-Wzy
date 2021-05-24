package com.wzy.wzy_shop.controller;

import com.wzy.wzy_shop.PathConstant;
import com.wzy.wzy_shop.entity.Vip;
import com.wzy.wzy_shop.service.VipService;
import com.wzy.wzy_shop.service.impl.VipServiceImpl;
import com.wzy.wzy_shop.util.R;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProfileServlet", value = "/vip/getProfile.do")
public class ProfileServlet extends HttpServlet {
    private VipService vipService = new VipServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        try {
            String username = request.getParameter("username");
            Vip vip = vipService.getVipProfile(username);
            response.addHeader("content-type", "application/json;charset=utf-8");
            writer.print(R.build().setCode(2000).setMsg("成功").add("image", PathConstant.IMAGE_BASE_PATH + vip.getProfile()).toJson());
        } catch (Exception e) {
            e.printStackTrace();
            writer.print(R.fail());
        } finally {
            writer.flush();
            writer.close();
        }
    }
}
