<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/14
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/style1.css" rel='stylesheet' type='text/css'/>
    <title>注册</title>
    <style>
        #tip{
            color: white;
        }
        #tip1{
            color: white;
        }
        /*.submit{
            width: 335px;
            height: 62px;
            background-color: orange;
            border: 2px orange solid;
            text-align: center;
            margin-left: 30px;
        }*/
        #register{
            height: 60px;
            width: 335px;
            font-size: 20px;
            text-align: center;
            line-height: 60px;
            color: white;
            font-weight: 300;
            background:#f9671e;
            border: 3px solid #f9671e;
            border-radius: 5px;
        }
        #register:hover{
            color: #f9671e;
            cursor: pointer;
            background: none;
        }

    </style>
</head>
<body>
<div>
    <h1> 账 号 注 册 </h1>
    <div class="app-cam">
        <div class="cam"><img src="images/注册服务.png" class="img-responsive" alt=""/></div>
        <form id="form" action="login">
            <input type="text" id="user" placeholder="请输入用户名" class="aaa">
            <div id="tip"></div>
            <input type="password" id="pwd" placeholder="请输入密码" class="aaa">
            <input type="password" id="pwds" placeholder="请确认输入密码" class="aaa">
            <div id="tip1"></div>
            <input type="text" id="sex" placeholder="请输入性别">
            <input type="text" id="tel" placeholder="请输入电话">
            <div class="submit"><input type="button" value="注 册" id="register" disabled="disabled"></div>
            <div class="clear"></div>
        </form>
    </div>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            var un;
            var pwd;
            var pwds;
            var tel;
            var sex;
            $(".aaa").keyup(function () {
                un = $("#user").val();
                pwd = $("#pwd").val();
                pwds = $("#pwds").val();
                tel = $("#tel").val();
                sex=$("#sex").val();
                $.ajax({
                    url: "doRegister",
                    type: "get",
                    data: {"us": un, "pwd": pwd, "pwds": pwds, "tel": tel,"sex":sex},
                    success: function (result) {
                        /*console.log(result);*/
                        if (result === "1") {
                            $("#tip").text("可以使用");
                            $("#register").attr("disabled", true);
                        }
                        if (result === "2") {
                            $("#tip").text("用户名已存在");
                            $("#register").attr("disabled", true);
                        }
                        if (result === "12") {
                            $("#tip").text("可以使用");
                            $("#tip1").text("密码不一致");
                            $("#register").attr("disabled", true);
                        }
                        if (result === "11") {
                            $("#tip").text("可以使用");
                            $("#tip1").text("密码一致");
                            $("#register").attr("disabled", false);
                        }
                        if (result === "22") {
                            $("#tip").text("用户名已存在");
                            $("#tip1").text("密码不一致");
                            $("#register").attr("disabled", true);
                        }
                        if (result === "21") {
                            $("#tip").text("用户名已存在");
                            $("#tip1").text("密码一致");
                            $("#register").attr("disabled", true);
                        }
                    }
                });

            });
            $("#register").click(function () {
                alert("注册成功");
                $("#form").submit()
            })
        })
    </script>
</div>
</body>
</html>
