<%--
  Created by IntelliJ IDEA.
  User: tangfuqiang
  Date: 2017/11/30
  Time: 下午7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <title>用户查询</title>
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
    <script src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
    <script src="<%=basePath%>js/jquery.twbsPagination.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/common.js"></script>
</head>

<body>
<div class="head">
    <img src="<%=basePath%>images/logo.png" class="img_head">
    <span class="title">用户管理系统</span>
    <div class="div_option">
        <a href="#" class="a_option_exit">退出</a>
        <a href="#" class="a_option_help">帮助</a>
    </div>
</div>
<div class="left">

    <p style="background-color: #C3C3C3"><a href="<%=basePath%>index/backoruserlist" class="left_a">用户查询</a></p>
    <hr>
    <p class="left_p2"><a href="<%=basePath%>index/toaddpage" class="left_a">用户新增</a></p>
    <hr>
    <p class="left_p2"><a href="<%=basePath%>index/tochartpage" class="left_a">用户分析</a></p>
    <img src="<%=basePath%>images/logo.png" class="left_img">
    <p><a href="#" class="login">当前用户登录</a></p>
</div>

<div class="main">
    <div>
        <br>
        &nbsp&nbsp&nbsp<a href="backoruserlist"><span>返回</span></a>

        <br>
        <br>
        <table border="1" cellspacing="
    0" id="table">
            <tr class="one">
                <td>ID</td>
                <td class="td_username">用户名称</td>
                <td class="ß">职业</td>
                <td class="td_email">邮箱</td>
                <td class="td_sex">性别</td>
                <td class="td_speciality">爱好</td>
                <td>生日</td>
                <td class="td_handle">操作</td>
            </tr>
            <c:forEach items="${userlist}" var="user">
                <tr class="tr_user">
                    <td class="td_id">${user.id}</td>
                    <td class="td_username">${user.username}</td>
                    <td class="td_profession">${user.occupation}</td>
                    <td class="td_email">${user.email}</td>
                    <td class="td_sex">${user.sex}</td>
                    <td class="td_speciality">${user.hobby}</td>
                    <td class="td_birthday">${user.birthday}</td>
                    <td class="td_handle" style='width:100px '>
                        <a class="update"><span href="#">编辑</span></a>

                        <a class="save" style="display: none;">
                            <span href="#" style='width: 20px'>保存</span></a>

                        &nbsp&nbsp<a class="remove"><span>删除</span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<div class="page1">
    <div class="am-cf">
        <div class="am-fr">
            <ul id="pagination-demo" class="pagination-sm"></ul>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    var paginator;
    var total;
    var start;
    $(document).ready(function () {
        paginator = $('#pagination-demo').twbsPagination({
            totalPages: ${querytotalPage},
            visiblePages: 3,
            startPage:${startPage},
            initiateStartPageClick: false,
            onPageClick: function (event, page) {
                $('#page-content').text('Page ' + ${startPage});
                window.location.href = "nexquerypage?startPage=" + page+"&username=${username}";
            }
        });

        $('#table').on('click','.remove',function () {
            var id = $(this).parent().siblings('.userId').text();
            var check = confirm("确定删除？");
            if (check) {
                var $pagination = $('#pagination-demo');
                $.ajax({
                    type: "POST",
                    url: "<%=basePath%>index/removequery?username=${username}",
                    data: {
                        id: id,
                        startPage:${startPage},
                    },
                    dataType: "json",
                    success: function (json) {
                        $('.tr_user').remove();
                        var counts = eval(json.userlist).length;
                        for (var i = 0; i < counts; i++) {
                            var tr = " <tr class=\"tr_user\">\n" +
                                "                    <td class=\"td_id\">" + json.userlist[i].id + "</td>\n" +
                                "                    <td class=\"td_username\">" + json.userlist[i].username + "</td>\n" +
                                "                    <td class=\"td_profession\">" + json.userlist[i].occupation + "</td>\n" +
                                "                    <td class=\"td_email\">" + json.userlist[i].email + "</td>\n" +
                                "                    <td class=\"td_sex\">" + json.userlist[i].sex + "</td>\n" +
                                "                    <td class=\"td_speciality\">" + json.userlist[i].hobby + "</td>\n" +
                                "                    <td class=\"td_birthday\">" + json.userlist[i].birthday + "</td>\n" +
                                "                   <td class=\"td_handle\" style='width:100px '><a class=\"update\"><span href=\"#\">编辑</span></a>" +
                                "                    <a class=\"save\" style=\"display: none;\">" +
                                "                    <span href=\"#\">保存</span></a>" +
                                "                    &nbsp&nbsp<a class=\"remove\" ><span >删除</span></a></td>\n" +
                                "                </tr>"
                            $('#table').append(tr);
                        }
                        start = json.startPage;
                        total = json.totalPage;
                        $pagination.twbsPagination('destroy');
                        $pagination.twbsPagination($.extend({}, {
                            startPage: (start),
                            totalPages: (total),
                            initiateStartPageClick: false,
                            onPageClick: function (event, page) {
                                $('#page-content').text('Page ' + ${startPage});
                                window.location.href = "<%=basePath%>index/nexquerypage?startPage=" + page+"&username=${username}";
                            }
                        }));
                    },
                    error: function (json) {
                        alert('服务器内部错误');
                        return false;
                    }
                })
                return false;
            }

        })
        var username;
        var occupation;
        var sex;
        var email;
        var hobby;
        var birthday;

        var oldusername;
        var oldoccupation;
        var oldsex;
        var oldemail;
        var oldhobby;
        var oldbirthday;
        $('#table').on('click', '.update', function () {
            $(this).css('display', 'none');

            $(this).siblings('.save').css('display', 'inline-block');

            username = $(this).parent().siblings('.td_username');
            occupation = $(this).parent().siblings('.td_profession');
            sex = $(this).parent().siblings('.td_sex');
            email = $(this).parent().siblings('.td_email');
            hobby = $(this).parent().siblings('.td_speciality');
            birthday = $(this).parent().siblings('.td_birthday');

            oldusername = username.text();
            oldoccupation = occupation.text();
            oldsex = sex.text();
            oldemail = email.text();
            oldhobby = hobby.text();
            oldbirthday = birthday.text();

            username.text("")
            username.append("<input type='text' class='updateusername' value=" + oldusername + " style='width: 100px'>");

            occupation.text("")
            occupation.append("<input type='text' value=" + oldoccupation + " style='width: 80px'>");

            sex.text("");
            sex.append("<input type='text' value=" + oldsex + " style='width: 80px'>");

            email.text("");
            email.append("<input type='text' value=" + oldemail + " style='width: 180px'>");

            hobby.text("");
            hobby.append("<input type='text' value=" + oldhobby + " style='width: 100px'>");

            birthday.text("");
            birthday.append("<input type='date' value=" + oldbirthday + " >");

        })


        $('#table').on('click', '.save', function () {
            var verify = confirm("确定修改？");
            if (verify) {
                var newusernaem = username.children('input').val();
                var newsex = sex.children('input').val();
                var newemail = email.children('input').val();
                var newhobby = hobby.children('input').val();
                var newbirthday = birthday.children('input').val();
                var newoccupation = occupation.children('input').val();
                var id = $(this).parent().siblings('.td_id').text();
                var usernamecheck = true;
                if(oldusername==newusernaem){
                    usernamecheck = false;
                }
                $.ajax({
                    type: "POST",
                    url: "<%=basePath%>index/updateuser",
                    data: {
                        id: id,
                        username: newusernaem,
                        sex: newsex,
                        email: newemail,
                        hobby: newhobby,
                        birthday: newbirthday,
                        occupation: newoccupation,
                        usernamecheck: usernamecheck,
                    },
                    dataType: "json",
                    success: function (json) {
                        if(json.check) {
                            alert('修改成功');
                            username.text(newusernaem);
                            sex.text(newsex);
                            email.text(newemail);
                            hobby.text(newhobby);
                            birthday.text(newbirthday);
                            occupation.text(newoccupation);
                        }else {
                            alert('用户名已存在');
                        }
                    },
                    error: function (json) {
                        alert('服务器内部错误,修改失败');
                        username.text(oldusername);
                        sex.text(oldsex);
                        email.text(oldemail);
                        hobby.text(oldhobby);
                        birthday.text(oldbirthday);
                        occupation.text(oldoccupation);
                    }

                })
                $(this).css('display', 'none');
                $(this).siblings('.update').css('display', 'inline-block');
                return false;

            } else {

                $(this).css('display', 'none');
                $(this).siblings('.update').css('display', 'inline-block');
                username.text(oldusername);
                sex.text(oldsex);
                email.text(oldemail);
                hobby.text(oldhobby);
                birthday.text(oldbirthday);
                occupation.text(oldoccupation);
            }
        })

    })
</script>
</html>

