<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>哈尔滨工业大学校友会</title>
    <link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link rel="stylesheet" type="text/css" href="../../resources/css/common.css">
</head>
<body>
<div class="weui-msg bd-m-t" style="margin-top: 20px;padding-top: 20px;">
    <div class="weui-msg__icon-area" style="margin-bottom: 20px;"><i class="weui-icon-success weui-icon_msg"></i></div>
    <div class="weui-msg__text-area">
        <h2 class="weui-msg__title">完成捐赠</h2>
        <c:if test="${empty out_trade_no}">
            <p class="weui-msg__desc">哈工大校友会感谢您的捐赠</p>
        </c:if>
        <c:if test="${!empty out_trade_no}">
            <p class="weui-msg__desc">感谢您的捐赠，下方领取您的捐赠证书吧</p>
        </c:if>
    </div>
</div>
<c:if test="${!empty out_trade_no}">
    <img style="width: 100%;height: auto;display: block;" src="/cer/${out_trade_no}.jpg">
</c:if>
</body>
</html>
