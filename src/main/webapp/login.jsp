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
<img src="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3275252298,1993070608&fm=26&gp=0.jpg" id="profile">
<form method="post" action="vip/login.do">
    <input type="text" name="username" id="username">
    <input type="password" name="password">
    <input type="submit" value="登录">
</form>

<script src="https://cdn.bootcdn.net/ajax/libs/jquery/2.2.4/jquery.js"></script>
<script>
    $("#username").blur(function () {
        $.get("/shop/vip/getProfile.do", {username: $("#username").val()}, function (data) {
            $("#profile").attr("src", data.map.image)
        })
    })
</script>
</body>
</html>
