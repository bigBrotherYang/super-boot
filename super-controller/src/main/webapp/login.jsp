<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/14
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>"></base>
</head>
<body>
    <form action="login" method="post">
        <input type="text" name="userName"/><br/>
        <input type="text" name="userPwd"><br/>
        <input type="checkbox" name="remember-me" value="true" checked="checked" />
        <security:csrfInput/>
        <input type="submit"><font color="red">${param.error==1?"账号密码错误":""}</font>
    </form>
</body>
</html>
