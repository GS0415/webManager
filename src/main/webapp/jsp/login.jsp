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
</head>
<body>
<h1>管 理 系 统</h1>
<div class="app-cam">
    <div class="cam"><img src="images/cam.png" class="img-responsive" alt=""/></div>
    <form id="form">
        <input type="text" id="user" class="text" placeholder="请输入用户名">
        <div id="tip"></div>
        <input type="password" class="text" placeholder="请输入密码" id="pwd">
        <div class="submit"><input type="submit" value="登 录"></div>
        <div class="clear"></div>
        <div class="new">
            <p><a href="#">忘 记 密 码 ?</a></p>
            <p class="sign"><a href="#"> 注 册</a></p>
            <div class="clear"></div>
        </div>
    </form>
</div>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script>
    $(function () {
        $(".text").change(function () {
            un = $("#user").val();
            pwd = $("#pwd").val();
            $.ajax({
                url:"doLogin",
                type:"post",
                data:{"un":un,"pwd":pwd},
                success:function (result) {
                    if(result=="1"){
                        alert("登录成功")
                    }if(result=="2"){
                        alert("密码错误");
                        pwd="";
                    }if(result=="3"){
                        alert("用户名错误")
                    }
                }
            })

        })
    })
</script>
</body>
</html>
