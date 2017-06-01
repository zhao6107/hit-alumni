<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>哈尔滨工业大学校友会微信服务号后台管理系统</title>
    <style type="text/css" rel="stylesheet">
        input, textarea {
            width: 250px;
            padding: 4px 8px;
        }

        span {
            position: relative;
        }
    </style>
</head>
<body>
<div style="padding-left: 20px;text-align: center;">
    <h2>联系人信息</h2>
    <hr>
    <div><br>
        姓　　名：<input disabled="disabled" value="${alumniInfo.name}"><br><br>
        入学年份：<input disabled="disabled" value="${alumniInfo.entryYear}"><br><br>
        班　　号：<input disabled="disabled" value="${alumniInfo.classNO}"><br><br>
        专　　业：<input disabled="disabled" value="${alumniInfo.major}"><br><br>
        院系名称：<input disabled="disabled" value="${alumniInfo.academy}"><br><br>
        联系方式：<input disabled="disabled"
                    value="${alumniInfo.contactInfo}（<c:choose><c:when test="${alumniInfo.contactInfo==2}">微信</c:when><c:when test="${alumniInfo.contactInfo==3}">QQ</c:when><c:otherwise>手机</c:otherwise></c:choose>）">
        <br><br>
        工作单位：<input disabled="disabled" value="${alumniInfo.company}"><br><br>
        工作职位：<input disabled="disabled" value="${alumniInfo.job}"><br><br>
        <p><a href="/wechat/admin/activities?page=1">返回返校活动列表</a></p>
    </div>
</div>
</body>
</html>
