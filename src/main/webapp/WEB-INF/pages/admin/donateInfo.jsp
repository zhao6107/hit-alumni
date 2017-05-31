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
    </style>
</head>
<body>
<div style="padding-left: 20px;text-align: center;">
    <h2>捐款信息</h2>
    <hr>
    <div><br>
        编　　号：<input disabled="disabled" value="${donateInfo.out_trade_no}"><br><br>
        捐款项目：<input disabled="disabled" value="${donateInfo.body}"><br><br>
        <%--项目描述：<input disabled="disabled" value="${donateInfo.detail}"><br><br>--%>
        项目描述：<textarea rows="3" disabled="disabled">${donateInfo.detail}</textarea><br><br>
        捐款金额：<input disabled="disabled"
                    value="<fmt:formatNumber value='${donateInfo.total_fee}' pattern='￥#0.00'/> "><br><br>
        捐款时间：<input disabled="disabled"
                    value="<fmt:formatDate value='${donateInfo.time_end}' pattern='yyyy-MM-dd HH:mm:ss'/>"><br><br>
        募捐来源：<input disabled="disabled" value="${donateInfo.origin}"><br><br>
        捐&ensp;款&ensp;人：<input disabled="disabled" value="${donateInfo.true_name}"><br><br>
        联系方式：<input disabled="disabled" value="${donateInfo.phone}"><br><br>
        入学年份：<input disabled="disabled" value="${donateInfo.entry_year}"><br><br>
        专　　业：<input disabled="disabled" value="${donateInfo.major}"><br><br>
        工作单位：<input disabled="disabled" value="${donateInfo.company}"><br><br>
        工作职位：<input disabled="disabled" value="${donateInfo.job}"><br><br>
        邮寄地址：<textarea rows="3" disabled="disabled">${donateInfo.mail_addr}</textarea><br><br>
        捐款留言：<textarea rows="5" disabled="disabled">${donateInfo.comment}</textarea><br>
        <p><a href="/wechat/admin/donate?page=1">返回捐款列表</a></p>
    </div>
</div>
</body>
</html>
