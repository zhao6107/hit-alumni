<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>哈尔滨工业大学校友会微信服务号后台管理系统</title>
    <style type="text/css" rel="stylesheet">
        table, tr, th, td {
            border: 1px solid #ccc;
        }

        table {
            width: auto;
            min-width: 800px;
            text-align: center;
        }
    </style>
</head>
<fundItemName>
<jsp:include page="nav_base.jsp" flush="true"/>
<div style="padding-left: 20px;">
    <h2>二维码捐款项</h2>
    <hr>
    <p>
        <a href="/wechat/admin/qrcode-items?opt=add">添加新的二维码捐款项目</a>
    </p>
    <hr>
    <table>
        <tr>
            <th>编号</th>
            <th>二维码捐款</th>
            <th>募捐项目描述</th>
            <th>固定捐款额</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${items}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.fundItemName}</td>
                <td>${item.fundItemId}</td>
                <td><fmt:formatNumber value="${item.money}" pattern="￥#0.00"/></td>
                <td>
                    <a href="/wechat/admin/qrcode-items/${item.id}?opt=qrcode">捐款二维码</a>
                    <a href="/wechat/admin/qrcode-items/${item.id}?opt=update">修改</a>
                    <a href="/wechat/admin/qrcode-items/${item.id}?opt=del"
                       onClick="return confirm('您确认要删除编号为${item.id}的捐款项目吗?');">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</fundItemName>
</html>
