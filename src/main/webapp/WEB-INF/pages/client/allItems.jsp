<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>哈尔滨工业大学校友会</title>
    <link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link rel="stylesheet" type="text/css" href="${applicationScope.globalUrlPrefix}/wechat/resources/css/common.css">
</head>
<body>
<div class="container js_container">
    <div class="hd">筹款项目列表</div>
    <div class="weui-panel" style="margin-top: 30px;">
        <div class="weui-panel__hd">点击筹款项目可进行捐助</div>
        <div class="weui-panel__bd">
            <c:forEach items="${items}" var="item">
                <a class="weui-media-box weui-media-box_text" style="display: block;"
                   href="${applicationScope.globalUrlPrefix}/wechat/donate/item/${item.id}">
                    <h4 class="weui-media-box__title">${item.body}</h4>
                    <p class="weui-media-box__desc">${item.detail}</p>
                    <ul class="weui-media-box__info">
                        <li class="weui-media-box__info__meta">已筹${item.raisedFund}元</li>
                        <li class="weui-media-box__info__meta">目标${item.targetFund}元</li>
                        <li class="weui-media-box__info__meta weui-media-box__info__meta_extra">
                            <fmt:formatDate value="${item.time_begin}" pattern="yyyy-MM-dd"/>
                        </li>
                    </ul>
                </a>
            </c:forEach>
            <!-- 当没有数据的时候 -->
            <c:if test="${empty items}">
                <div class="weui-loadmore weui-loadmore_line">
                    <span class="weui-loadmore__tips">暂无数据</span>
                </div>
            </c:if>
        </div>
    </div>
    <div>&nbsp;</div>
</div>
<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script>
    wx.config({
        debug: ${requestScope.jsSdkConfig.debug},
        appId: '${requestScope.jsSdkConfig.appId}',
        timestamp:${requestScope.jsSdkConfig.timestamp},
        nonceStr: '${requestScope.jsSdkConfig.nonceStr}',
        signature: '${requestScope.jsSdkConfig.signature}',
        jsApiList: ${requestScope.jsSdkConfig.jsApiList}
    });
    wx.ready(function () {
        wx.hideAllNonBaseMenuItem();
    });
</script>
</body>
</html>

