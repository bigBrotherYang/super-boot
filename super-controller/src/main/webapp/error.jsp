<%--
  Created by IntelliJ IDEA.
  User: YangML
  Date: 2020/9/17
  Time: 上午10:06
  version:TODO
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
        认证失败
</body>
</html>
