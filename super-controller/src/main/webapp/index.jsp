<%--
  Created by IntelliJ IDEA.
  User: YangML
  Date: 2020/9/16
  Time: 下午4:36
  version:TODO
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
    <form method="post" action="logout" >
            <security:csrfInput/>
            <input type="submit" value="注销">
    </form>
</body>
</html>
