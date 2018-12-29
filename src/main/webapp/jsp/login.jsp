<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/21
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <link href="css/style1.css" rel='stylesheet' type='text/css'/>
    <style>
        #login {
            height: 60px;
            width: 335px;
            font-size: 20px;
            text-align: center;
            line-height: 60px;
            color: white;
            font-weight: 300;
            background: #f9671e;
            border: 3px solid #f9671e;
            border-radius: 5px;
        }
        #login:hover {
            color: #f9671e;
            cursor: pointer;
            background: none;
        }
    </style>
</head>
<body>
<h1>管 理 系 统</h1>
<div class="app-cam">
    <div class="can"><img src="images/头像.png" class="img-responsive" alt=""/></div>
    <form id="form" action="listOne" method="post">
        <input type="text" id="user" name="name" placeholder="请输入用户名">
        <input type="password" placeholder="请输入密码" id="pwd">
        <div class="submit"><input type="button" value="登 录" id="login"></div>
        <div class="clear"></div>
        <div class="new">
            <p><a href="#">忘 记 密 码 ?</a></p>
            <p class="sign"><a href="register"> 注 册</a></p>
            <div class="clear"></div>
        </div>
    </form>
</div>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script>
    $(function () {
        $("#login").click(function () {
            un = $("#user").val();
            pwd = $("#pwd").val();
            $.ajax({
                url: "doLogin",
                type: "post",
                data: {"un": un, "pwd": pwd},
                async: false,
                success: function (result) {
                    if (result === "1") {
                        alert("登录成功");
                        $("#form").submit();
                    } else {
                        alert("用户名或密码错误");
                    }
                }
            })
        })
    })
</script>
</body>
</html>
