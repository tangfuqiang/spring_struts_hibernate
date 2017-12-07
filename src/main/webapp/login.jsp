<%--
  Created by IntelliJ IDEA.
  User: tangfuqiang
  Date: 2017/11/28
  Time: 下午10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="<%=basePath%>css/login.css"/>
    <script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/common.js"></script>
</head>
<body>
<form>
    <div class="box">
        <div>
            <img src="<%=basePath%>images/login.jpg" class="login">
        </div>
        <div class="logo">
            <img src="<%=basePath%>images/login_logo.png">
            <b class="font">系统登录</b>
        </div>
        <div class="cutting-line">
            <hr>
        </div>
        <div class="account">
            账户：
            <input type="text" name="username" placeholder=" 请输入您的用户名!" class="account-password" id="account"
                   onkeyup="this.value=this.value.replace(/^ +| +$/g,'')" required="required">
            <br>
            <br>密码：
            <input type="password" name="password" placeholder=" 请输入您的登录密码!" class="account-password" id="password"
                   onkeyup="this.value=this.value.replace(/^ +| +$/g,'')" required="required">
            <br>
            <br>
            <input type="checkbox" id="remember">
            <span onclick="remember()">记住密码</span>
        </div>
        <div>
            <ul class="btn">
                <li>
                    <button type="submit" id="login">登录</button>
                </li>
                <li>
                    <button type="reset">重置</button>
                </li>
                <li>
                    <button>注册</button>
                </li>
            </ul>
        </div>
    </div>
</form>
</body>
<script type="text/javascript">
    $(document).ready(function () {

        $('#login').click(function () {
            var account = $('#account').val();
            var password = $('#password').val();
            if (account == "" || password == "") {
                   alert("请输入登录信息              ")
            } else {

                $.ajax({
                    type: "POST",
                    url: "login_check",
                    data: {
                        username: account,
                        password: password,
                    },
                    dataType: "json",
                    success: function (json) {
                        if (json.check) {
                            window.location.href = '<%=basePath%>index/login_pass'
                        } else {
                            alert('账号或密码错误');
                        }

                    },
                    error: function (json) {
                        return false;
                    }
                })
                return false;
            }
        })

    })
</script>
</html>
