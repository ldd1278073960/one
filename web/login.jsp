<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/15
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function ff() {
            window.location.href = "registered.jsp";
        }
    </script>
</head>
<body>
<div style="color: red">${msg}</div>
<div style="color: red">${smg}</div>
<form action="LoginServlet" method="post">
    用户名：<input type="text" name="username" /><br>
    密码：<input type="password" name="password" /><br>
    <input type="submit" value="登陆" />
    <input type="button" value="注册" onclick="ff()" />
</form>

</body>
</html>
