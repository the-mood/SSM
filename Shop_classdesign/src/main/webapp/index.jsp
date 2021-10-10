<%--
  Created by IntelliJ IDEA.
  User: yang97
  Date: 2020/6/17
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#register").click(function () {
                window.location.href="register.jsp"
            })
        })
    </script>
</head>
<body>
    <form action="user/login" method="post">
        姓名：<input type="text" name="username" /><br/>
        密码：<input type="text" name="password" /><br/>
        <input type="submit" value="登录"/><input type="button" value="注册" id="register"/>
    </form>

</body>
</html>
