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
<form method="post" action="vip/vip.do">
    用户名：<input type="text" name="username" id="username"> <span style="color: red" id="msg"></span><br>
    密码：<input type="password" name="password"><br>
    性别：男<input type="radio" name="gender" value="男">
         女<input type="radio" name="gender" value="女"><br>
    <input type="submit" value="提交">
</form>

<script>
    document.getElementById("username").addEventListener("blur", function (){
        var xhr = new XMLHttpRequest();
        xhr.open("get", "/");
        document.getElementById("msg").innerText = "用户名已占用";
    });
</script>
</body>
</html>
