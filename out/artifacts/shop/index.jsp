<%--
  Created by IntelliJ IDEA.
  User: cuber
  Date: 2021/5/9
  Time: 10:59
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
<a href="login.jsp" target="_blank">登录</a>
<a href="register.jsp" target="_blank">注册</a>
</body>
</html>
