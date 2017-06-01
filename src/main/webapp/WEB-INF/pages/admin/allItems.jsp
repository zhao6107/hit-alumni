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
<body>
<jsp:include page="nav_base.jsp" flush="true"/>
<div style="padding-left: 20px;">
    <h2>
        <c:choose>
            <c:when test="${status=='on'}">正在进行的捐款项目</c:when>
            <c:otherwise>已结束的捐款项目</c:otherwise>
        </c:choose>
    </h2>
    <hr>
    <p>
        <a href="/wechat/admin/items?opt=add">添加新的捐款项目</a>
        <c:choose>
            <c:when test="${status=='on'}">
                <a href="/wechat/admin/items?status=off">已结束的捐款项目</a>
            </c:when>
            <c:otherwise>
                <a href="/wechat/admin/items?status=on">正在进行的捐款项目</a>
            </c:otherwise>
        </c:choose>
    </p>
    <hr>
    <table>
        <tr>
            <th>编号</th>
            <th>发起时间</th>
            <th>募捐项目名称</th>
            <th>募捐项目描述</th>
            <th>目标筹集资金</th>
            <th>已筹集资金</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${items}" var="item">
            <tr>
                <td>${item.id}</td>
                <td><fmt:formatDate value="${item.time_begin}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${item.body}</td>
                <td>${item.detail}</td>
                <td>${item.targetFund}元</td>
                <td>${item.raisedFund}元</td>
                <td>
                    <c:choose>
                        <c:when test="${status=='on'}">
                            <a href="/wechat/admin/items/${item.id}?opt=update">修改</a>
                            <a href="/wechat/admin/items/${item.id}?opt=finish"
                               onClick="return confirm('您确认要终止编号为${item.id}的捐款项目吗?');">终止</a>
                        </c:when>
                        <c:otherwise>
                            <a href="/wechat/admin/items/${item.id}?opt=recover"
                               onClick="return confirm('您确认要恢复编号为${item.id}的捐款项目吗?');">恢复</a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
