<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/14
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form action="doUpdate">
    <input type="text" name="id" value="${pro.productId}" hidden="hidden">
    商品名称：<input type="text" name="name" value="${pro.productName}"><br>
    商品价格：<input type="text" name="price" value="${pro.productPrice}"><br>
    商品图片：<input type="text" name="url" value="${pro.productUrl}"><br>
    商品描述：<input type="text" name="des" value="${pro.productDes}"><br>
    <input type="submit" value="修改">
</form>
</body>
</html>
