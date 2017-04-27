<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>哈尔滨工业大学校友会</title>
    <style type="text/css" rel="stylesheet">
        table, tr, td {
            border: 2px solid #cccccc;
        }
    </style>
</head>
<body>
<div style="padding-left: 8px;">
    <h2>募捐项目</h2>
    <table>
        <tr>
            <th>编号</th>
            <th>发起时间</th>
            <th>募捐项目名称</th>
            <th>募捐项目描述</th>
            <th>目标筹集资金</th>
            <th>已筹集资金</th>
            <th>捐助</th>
        </tr>
        <c:forEach items="${items}" var="item">
            <tr>
                <td>${item.id}</td>
                <td><fmt:formatDate value="${item.time_begin}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${item.body}</td>
                <td>${item.detail}</td>
                <td>${item.targetFund}元</td>
                <td>${item.raisedFund}元</td>
                <td><a href="/donate/item/${item.id}">去捐助</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
