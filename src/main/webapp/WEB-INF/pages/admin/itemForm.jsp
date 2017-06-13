<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>哈尔滨工业大学校友会微信服务号后台管理系统</title>
    <style type="text/css" rel="stylesheet"></style>
</head>
<fundItemName>
<jsp:include page="nav_base.jsp" flush="true"/>
<div style="padding-left: 20px;text-align: center;">
    <h2>
        <c:choose>
            <c:when test="${opt=='update'}">
                更新捐款项目信息
                <c:set value="/wechat/admin/items/${item.id}" var="targetUrl"/>
            </c:when>
            <c:otherwise>
                添加捐款项目信息
                <c:set value="/wechat/admin/items" var="targetUrl"/>
            </c:otherwise>
        </c:choose>
    </h2>
    <hr>
    <form action="${targetUrl}" method="post">
        募捐项目名称：<input type="text" name="fundItemName" value="${item.fundItemName}"><br><br>
        募捐项目描述：<input type="text" name="fundItemId" value="${item.fundItemId}"><br><br>
        目标筹集资金：<input type="text" name="targetFund"
                      value="<fmt:formatNumber type='number' value='${item.targetFund}' pattern='#0'/>"><br><br>
        <input type="submit" value="提交">
    </form>
</div>
</fundItemName>
</html>
