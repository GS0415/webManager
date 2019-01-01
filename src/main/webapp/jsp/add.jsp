<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/14
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        body {
            background: lightblue;
        }

        #top {
            height: 100px;
            text-align: center;
            line-height: 100px;
        }

        #main {
            width: 1100px;
            /*  border: black 1px solid;*/
            margin: auto;

        }

        #left {
            width: 350px;
            height: 600px;
            /*border: 1px white solid;*/
            /*display: flex;*/
            vertical-align: top;
            /*  background-image: url("jsp/背景.png");*/
            background-size: 350px 600px;
            flex-wrap: wrap;
            display: inline-block;
        }

        #right {
            width: 700px;
            height: 600px;
            /* border: 1px white solid;*/
            display: inline-block;
            margin-left: 20px;
            vertical-align: top;
            /*   background: url("jsp/right.png");*/

        }

        .left-1 {
            width: 290px;
            height: 90px;
            margin: auto;
            border: 2px white solid;
            background-color: #f9671e;
            color: white;
            text-align: center;
            line-height: 90px;
            font-weight: 300;
            font-size: 20px;
            font-family: 楷体;
            margin-top: 20px;
            border-radius: 20px;

        }

        a {
            text-decoration-line: none;
        }

        .left-1:hover {
            background: none;
            border: 2px #f9671e solid;
            color: #f9671e;

        }

        #left-2 {
            width: 290px;
            height: 90px;
            margin: auto;
            border: 2px white solid;
            background-color: #f9671e;
            color: white;
            font-weight: 300;
            font-size: 20px;
            font-family: 楷体;
            border-radius: 20px;
            margin-top: 10px;
        }

        td a {
            color: red;
            text-decoration: none;
        }

        .left-text {
            color: white;
            width: 290px;
            height: 35px;
            /*border: 1px black solid;*/
            text-align: center;
            line-height: 35px;
        }

        #form {
            width: 500px;
            height: 300px;
            margin-top: 20px;
            line-height: 10px;
            margin-left: 100px;

        }

        .inp {

            height: 20px;
            margin-top: 30px;

        }

        #right-1 {
            width: 500px;
            height: 400px;
            border: white 2px solid;
            margin-top: 100px;
            margin-left: 150px;
            background: #f9671e;
            color: white;
        }

        #right-1:hover {
            border: #f9671e 2px solid;
            background: none;
            color: #f9671e;
        }
    </style>
</head>
<body>

<div id="top">
    <h1>后 台 管 理 系 统</h1>
</div>
<div id="main">
    <div id="left">
        <label>
            <a href="listOne">
                <div id="left-2"> 个人信息:
                    <div class="left-text">欢迎 ${user.userName}</div>
                </div>
            </a>
        </label>
        <label>
            <a href="list">
                <div class="left-1">商品管理</div>
            </a>
        </label>
        <label>
            <a href="listTwo">
                <div class="left-1">品牌管理</div>
            </a>
        </label>
        <label>
            <a href="add"><%--添加--%>
                <div class="left-1">添加商品</div>
            </a>
        </label>
        <label>
            <a href="addMark"><%--修改--%>
                <div class="left-1">添加品牌</div>
            </a>
        </label>
    </div>
    <div id="right">
        <div id="right-1">
            <form action="doAdd" method="post" enctype="multipart/form-data" id="form">
                商品名称：<input type="text" name="name" class="inp"><br>
                商品价格：<input type="text" name="price" class="inp"><br>
                商品图片：<input type="file" name="url" class="inp"><br>
                商品描述：<input type="text" name="des" class="inp"><br>
                商品数量：<input type="text" name="count" class="inp"><br>
                品牌：<select name="mark" class="inp">
                <c:forEach items="${markList}" var="m">
                    <option value="${m.markId}">${m.markName}</option>
                </c:forEach>
            </select>
                <input type="submit" value="添加">
            </form>
        </div>
    </div>
</div>

</body>
</html>
