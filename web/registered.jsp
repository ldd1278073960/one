<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/15
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<div style="color: red">${msg}</div>
<form action="registeredServlet" method="post">
    <div style="text-align: center" >用户注册</div>
<table border="2" align="center" cellspacing="1">
    <tr>
        <td>id：</td>
        <td><input type="text" name="Id" /></td>
    </tr>
    <tr>
        <td>用户名：</td>
        <td><input type="text" name="username" /></td>
    </tr>
    <tr>
        <td>密码：</td>
        <td><input type="password" name="password" /></td>
    </tr>
    <tr>
        <td>确认密码：</td>
        <td><input type="password" name="password1" /></td>
    </tr>
    <tr>
        <td>手机号码：</td>
        <td><input type="text" name="phone" /></td>
    </tr>
    <tr>
        <td>e-mail：</td>
        <td><input type="text" name="email" /></td>
    </tr>
    <tr>
        <td>地址：</td>
        <td><input type="text" name="addrs" /></td>
    </tr>
    <tr>
        <td>状态值：</td>
        <td><input type="text" name="flag" /></td>
    </tr>
    <tr>
        <td>性别：</td>
        <td><select name="sex">
            <option>  </option>
            <option>男</option>
            <option>女</option>
        </select>
        </td>
    </tr>
    <tr>
        <td>兴趣爱好：</td>
        <td><input type="checkbox" value="打篮球" name="hobbys" />打篮球
            <input type="checkbox" value="游泳" name="hobbys" />游泳<br>
            <input type="checkbox" value="下棋" name="hobbys" />下棋
            <input type="checkbox" value="蹴鞠" name="hobbys" />蹴鞠
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="submit" value="注册" />
            <input type="submit" value="返回"  />
        </td>
    </tr>
</table>
</form>
</body>
</html>
