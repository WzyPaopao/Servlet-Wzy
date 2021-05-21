package com.wzy.wzy_shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.wzy.wzy_shop.service.VipService;
import com.wzy.wzy_shop.service.impl.VipServiceImpl;
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
        String username = request.getParameter("username");
        PrintWriter writer = response.getWriter();

        // 是否已存在用户名
        boolean isExist = vipService.checkUserIsExist(username);

        if (isExist) {
            R r = R.build();
            r.setCode(200);
            r.setMsg("go");
            System.out.println("===========");
            System.out.println(r);
            System.out.println(JSONObject.toJSONString(r));
//            writer.print(JSONObject.toJSONString(R.build().setCode(5001).setMsg("好像失败了").add("name", "alan").add("age", "13")));
        } else {
            String rStr = R.success();
            writer.print(rStr);
        }

        response.getWriter().flush();
        response.getWriter().close();
    }
}
