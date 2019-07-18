<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/16
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    function delet() {
        window.location.href = "goodDeleteServlet";
    }
    function goodSave() {
        window.location.href = "good_save.jsp";
    }
</script>
<body>
<form action="goodQueryServlet" method="post">
    <div align="center">商品首页</div>
    <table border="2" align="center" cellspacing="1">
        <thead>
        <tr>
            <td>商品ID</td>
            <td>商品名称</td>
            <td>商品图片</td>
            <td>商品价格</td>
            <td>商品简介</td>
            <td>商品库存</td>
            <td>商品状态</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="goodInfo" >
                <tr>
                    <td>${goodInfo.id}</td>
                    <td>${goodInfo.goodsInfoName}</td>
                    <td><a href="downloadFileServlet?fileName=${goodInfo.goodInfoPic}" >
                        <img src="upload/${goodInfo.goodInfoPic}" width="50px" height="50px" />
                    </a></td>
                    <td>${goodInfo.goodsInfoPrice}</td>
                    <td>${goodInfo.goodsInfoDescription}</td>
                    <td>${goodInfo.goodsStock}</td>
                    <td>${goodInfo.flag}</td>
                    <td>
                        <input type="button" value="修改" onclick="onUpdateUrl('${goodInfo}')" />
                        <input type="button" value="删除" onclick="delet()"/>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="8" align="center" >
                <input type="button" value="添加" onclick="goodSave()" />
            </td>
        </tr>
        </tfoot>
    </table>
</form>
</body>
</html>
