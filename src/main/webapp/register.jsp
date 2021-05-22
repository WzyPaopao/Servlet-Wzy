<%--
  Created by IntelliJ IDEA.
  User: cuber
  Date: 2021/5/9
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
            request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="vip/vip.do" id="registerForm">
    用户名：<input type="text" name="username" id="username"> <span style="color: red" id="msg"></span><br>
    密码：<input type="password" name="password"><br/>
    性别：男<input type="radio" name="gender" value="男">
         女<input type="radio" name="gender" value="女"><br/>
    <input type="file" name="profile"/>
    <input type="button" value="提交" id="submitBtn"/>
</form>

<script src="https://cdn.bootcdn.net/ajax/libs/jquery/2.2.4/jquery.js"></script>
<script>
    // 提交按钮的点击事件
    document.getElementById("submitBtn").addEventListener("click", function () {
        if (!/^a/.test(document.getElementById("username").value)) {
            alert("您的用户名不合法");
        } else {
            document.getElementById("registerForm").submit();
        }
    });

    // 使用ajax请求，返回json数据判断用户名是否重复
    document.getElementById("username").addEventListener("blur", function (){
        const url = "/shop/vip/checkUser.do?username=" + document.getElementById("username").value;
        $.get(url, function (data) {
            console.log(data);
            document.getElementById("msg").innerText = data.msg;
        });
    });
</script>
</body>
</html>
