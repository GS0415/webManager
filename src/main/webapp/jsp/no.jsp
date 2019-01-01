<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/1
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #tip{
            width: 500px;
            height: 100px;
            margin: auto;
            text-align: center;
            line-height: 100px;
            color: #f9671e;
        }
        #inp{
            width: 50px;
            height: 30px;
            margin-left: 700px;
        }
    </style>
</head>
<body>
    <div id="tip"><h1>对不起，您没有权限</h1></div>
    <form action="doNo">
        <input type="submit" id="inp" value="返回">
    </form>
</body>
</html>
