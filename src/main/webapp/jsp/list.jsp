<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/12
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <title>商品列表</title>
    <style>
        table {
            border-collapse: collapse;
        }

        th {
            width: 100px;
            height: 50px;
            border: 1px saddlebrown solid;
        }

        td {
            width: 100px;
            height: 50px;
            border: 1px saddlebrown solid;
            text-align: center;
        }

        tr:nth-child(odd) {
            background-color: beige;
        }

        td a {
            color: red;
            text-decoration: none;

        }
    </style>
</head>
<body>

<table class="table table-hover">
    <tr>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品图片</th>
        <th>商品描述</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="pro">
        <tr>
            <td>${pro.productName}</td>
            <td>${pro.productPrice}</td>
            <td>${pro.productUrl}</td>
            <td>${pro.productDes}</td>
            <td><a href="delete?productId=${pro.productId}">删除</a>
                <a href="update?productId=${pro.productId}">修改</a>
            </td>
        </tr>
    </c:forEach>
    <form action="add">
        <input type="submit" value="添加">
    </form>
</table>
</body>
</html>
