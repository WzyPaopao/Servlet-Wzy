package com.wzy.wzy_shop.controller;

import com.wzy.wzy_shop.service.VipService;
import com.wzy.wzy_shop.service.impl.VipServiceImpl;
import com.wzy.wzy_shop.util.PatternUtil;
import com.wzy.wzy_shop.util.R;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckUserServlet", value = "/vip/checkUser.do")
public class CheckUserServlet extends HttpServlet {
    private VipService vipService = new VipServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader("content-type", "application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();

        try {
            String username = request.getParameter("username");

            // 判断是否已存在用户名
            boolean isExist = vipService.checkUserIsExist(username);
            String rStr;
            if (isExist) {
                rStr = R.build().setCode(2001).setMsg("用户名已存在").toJson();
            } else {
                rStr = R.build().setCode(2002).setMsg("用户名可用").toJson();
            }
            writer.print(rStr);
        } catch (Exception e) {
            e.printStackTrace();
            writer.print(R.build().setCode(5000).setMsg("后台出现异常").toJson());
        } finally {
            response.getWriter().flush();
            response.getWriter().close();
        }
    }
}
