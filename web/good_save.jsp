<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/17
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
    <script type="text/javascript">
        function cancel() {
            window.location.href = "/goodQueryServlet";
        }
    </script>
</head>
<body>
<form action="goodInsertServlet" method="post" enctype="multipart/form-data">
    <div align="center">添加页面</div>
    <table border="2" align="center" cellspacing="1">
        <tr>
            <td>商品名称：</td>
            <td><input type="text" name="goodsInfoName" /></td>
        </tr>
        <tr>
            <td>商品图片：</td>
            <td><input type="file" name="goodsInfoPic" /></td>
        </tr>
        <tr>
            <td>商品价格：</td>
            <td><input type="text" name="goodsInfoPrice" /></td>
        </tr>
        <tr>
            <td>商品简介</td>
            <td><input type="text" name="goodsInfoDescription" /></td>
        </tr>
        <tr>
            <td>商品库存：</td>
            <td><input type="text" name="goodsStock" /></td>
        </tr>
        <tr>
            <td>商品状态：</td>
            <td><input type="text" name="flag" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="添加" />
                <input type="button" value="取消" onclick="cancel()" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
