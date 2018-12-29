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

    <title>添加品牌</title>
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
            /* background-image: url("jsp/背景.png");*/
            background-size: 350px 600px;
            flex-wrap: wrap;
            display: inline-block;
        }

        #right {
            width: 700px;
            height: 600px;
            display: inline-block;
            margin-left: 20px;
            vertical-align: top;
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

        tr:nth-child(1) {
            background: #f9671e;
        }

        tr:hover {
            background-color: #f9671e;
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
        <form action="doAddMark" method="post" enctype="multipart/form-data">
            品牌名称：<input type="text" name="name"><br>
            logo：<input type="file" name="url"><br>
            <input type="submit" value="添加">
        </form>
    </div>
</div>

</body>
</html>