<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>哈尔滨工业大学校友会微信服务号后台管理系统</title>
    <style type="text/css" rel="stylesheet">
        table, tr, td {
            border: 2px solid #cccccc;
        }
    </style>
</head>
<body>
<div style="padding-left: 20px;">
    <h2>
        <c:choose>
            <c:when test="${item.body!=null}">
                更新
                <c:set value="/admin/item/${item.id}/update" var="targetUrl"/>
            </c:when>
            <c:otherwise>
                添加
                <c:set value="/admin/item/add" var="targetUrl"/>
            </c:otherwise>
        </c:choose>
        捐款项目
    </h2>
    <form action="${targetUrl}" method="post">
        募捐项目名称：<input type="text" name="body" value="${item.body}">
        募捐项目描述：<input type="text" name="detail" value="${item.detail}">
        目标筹集资金：<input type="text" name="targetFund" value="${item.targetFund}">
        <input type="hidden" name="itemId" value="${item.id}">
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
