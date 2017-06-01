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
            text-align: right;
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
    <h2>捐款记录</h2>
    <hr>
    <table>
        <tr>
            <th>捐款时间</th>
            <th>捐款项目</th>
            <th>捐款金额</th>
            <th>姓名</th>
            <th>入学年份</th>
            <th>专业</th>
            <th>联系方式</th>
            <th>单位</th>
            <th>职位</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pageDonates.pageRecords}" var="item">
            <tr>
                <td><fmt:formatDate value="${item.time_end}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${item.body}</td>
                <td><fmt:formatNumber value="${item.total_fee}" pattern="￥#0.00"/></td>
                <td>${item.true_name}</td>
                <td>${item.entry_year}</td>
                <td>${item.major}</td>
                <td>${item.phone}</td>
                <td>${item.company}</td>
                <td>${item.job}</td>
                <td><a href="/wechat/admin/donate/${item.out_trade_no}">查看</a></td>
            </tr>
        </c:forEach>
    </table>
    <div>
        当前为${pageDonates.pageIndex}页，每页${pageDonates.pageSize}条记录&nbsp;|&nbsp;共${pageDonates.totalRecord}条记录，总共${pageDonates.totalPage}页
        &nbsp;|&nbsp;
        <c:choose>
            <c:when test="${pageDonates.pageIndex-1<1}">上一页</c:when>
            <c:otherwise><a href="/wechat/admin/donate?page=${pageDonates.pageIndex-1}">上一页</a></c:otherwise>
        </c:choose>，
        <c:choose>
            <c:when test="${pageDonates.pageIndex+1>pageDonates.totalPage}">下一页</c:when>
            <c:otherwise><a href="/wechat/admin/donate?page=${pageDonates.pageIndex+1}">下一页</a></c:otherwise>
        </c:choose>
        &nbsp;|&nbsp;
        <form action="/wechat/admin/donate" method="get" style="display:inline;">
            <input type="number" name="page" value="1" style="width: 50px;">
            <input type="submit" value="跳转">
        </form>
    </div>
</div>
</body>
</html>
