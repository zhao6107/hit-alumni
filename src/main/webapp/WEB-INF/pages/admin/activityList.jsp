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

        td {
            padding-left: 8px;
            padding-right: 8px;
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
    <h2>返校活动登记信息</h2>
    <hr>
    <table>
        <tr>
            <th>开始日期</th>
            <th>结束日期</th>
            <th>返校人数</th>
            <th>校史馆</th>
            <th>航天馆</th>
            <th>博物馆</th>
            <th>校友总会</th>
            <th>学校采访</th>
            <th>开讲座</th>
            <th>志愿者</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pageActivities.pageRecords}" var="item">
            <tr>
                <td><fmt:formatDate value="${item.beginDate}" pattern="yyyy-MM-dd"/></td>
                <td><fmt:formatDate value="${item.endDate}" pattern="yyyy-MM-dd"/></td>
                <td>${item.alumniNum}</td>
                <td><fmt:formatDate value="${item.historyMuseumVisitedDate}" pattern="yyyy-MM-dd HH:mm"/></td>
                <td><fmt:formatDate value="${item.astronauticsMuseumVisitedDate}" pattern="yyyy-MM-dd HH:mm"/></td>
                <td><fmt:formatDate value="${item.schoolMuseumVisitedDate}" pattern="yyyy-MM-dd HH:mm"/></td>
                <td>
                    <c:choose>
                        <c:when test="${item.meetAlumniAssociation==1}">
                            是
                        </c:when>
                        <c:otherwise>否</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${item.acceptInterview==1}">
                            是
                        </c:when>
                        <c:otherwise>否</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${item.giveLecture==1}">
                            是
                        </c:when>
                        <c:otherwise>否</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${item.needVolunteer==1}">
                            是
                        </c:when>
                        <c:otherwise>否</c:otherwise>
                    </c:choose>
                </td>
                <td><a href="/wechat/admin/activities/${item.openId}">联系人</a></td>
            </tr>
        </c:forEach>
    </table>
    <div>
        当前为${pageActivities.pageIndex}页，每页${pageActivities.pageSize}条记录&nbsp;|&nbsp;共${pageActivities.totalRecord}条记录，总共${pageActivities.totalPage}页
        &nbsp;|&nbsp;
        <c:choose>
            <c:when test="${pageActivities.pageIndex-1<1}">上一页</c:when>
            <c:otherwise><a href="/wechat/admin/activities?page=${pageActivities.pageIndex-1}">上一页</a></c:otherwise>
        </c:choose>，
        <c:choose>
            <c:when test="${pageActivities.pageIndex+1>pageActivities.totalPage}">下一页</c:when>
            <c:otherwise><a href="/wechat/admin/activities?page=${pageActivities.pageIndex+1}">下一页</a></c:otherwise>
        </c:choose>
        &nbsp;|&nbsp;
        <form action="/wechat/admin/activities" method="get" style="display:inline;">
            <input type="number" name="page" value="1" style="width: 50px;">
            <input type="submit" value="跳转">
        </form>
    </div>
</div>
</fundItemName>
</html>
