<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/10
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎来到英雄联盟</title>
    <style>

        #menu {
            /* background-image:url("1.jpg");*/
            width: 1920px;
            height: 1080px;
            background-color: beige;

        }
    </style>
</head>
<body>
<div id="menu">
    <%
        System.out.println(request.getAttribute("width"));
    %>
</div>
</body>
</html>
