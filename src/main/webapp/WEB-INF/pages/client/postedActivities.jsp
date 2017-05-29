<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <div class="hd">我的返校活动</div>
    <div class="weui-btn-area" style="text-align: right;margin-top: 16px;margin-bottom: 16px;">
        <a id="btn-sbt" class="weui-btn weui-btn_mini weui-btn_primary btn-c"
           href="${applicationScope.globalUrlPrefix}/wechat/alumni/back-school?openId=${openId}">添加返校信息&nbsp;&gt;&gt;</a>
    </div>
    <!-- 展示正在进行的返校活动 -->
    <c:if test="${not empty activities[2]}">
        <div class="weui-panel">
            <div class="weui-panel__hd">正在进行的返校活动</div>
            <div class="weui-panel__bd">
                <a class="weui-media-box weui-media-box_text" style="display: block;"
                   href="${applicationScope.globalUrlPrefix}/wechat/alumni/back-school/${activities[2].id}">
                    <h4 class="weui-media-box__title">
                        <fmt:formatDate value="${activities[2].beginDate}" pattern="yyyy-MM-dd"/> 至 <fmt:formatDate
                            value="${activities[2].endDate}" pattern="yyyy-MM-dd"/>
                    </h4>
                    <ul class="weui-media-box__info">
                        <li class="weui-media-box__info__meta">返校人数${activities[2].alumniNum}人</li>
                        <li class="weui-media-box__info__meta weui-media-box__info__meta_extra">点击查看详情&nbsp;&gt;&gt;
                        </li>
                    </ul>
                </a>
            </div>
        </div>
    </c:if>
    <!-- 展示正在进行的返校活动 -->
    <c:if test="${not empty activities[3]}">
        <div class="weui-panel">
            <div class="weui-panel__hd">尚未开始的返校活动</div>
            <div class="weui-panel__bd">
                <a class="weui-media-box weui-media-box_text" style="display: block;"
                   href="${applicationScope.globalUrlPrefix}/wechat/alumni/back-school/${activities[3].id}">
                    <h4 class="weui-media-box__title">
                        <fmt:formatDate value="${activities[3].beginDate}" pattern="yyyy-MM-dd"/> 至 <fmt:formatDate
                            value="${activities[3].endDate}" pattern="yyyy-MM-dd"/>
                    </h4>
                    <ul class="weui-media-box__info">
                        <li class="weui-media-box__info__meta">返校人数${activities[3].alumniNum}人</li>
                        <li class="weui-media-box__info__meta weui-media-box__info__meta_extra">点击查看详情&nbsp;&gt;&gt;
                        </li>
                    </ul>
                </a>
            </div>
        </div>
    </c:if>
    <!-- 已经结束的返校活动 -->
    <c:if test="${(not empty activities[1]) && fn:length(activities[1])>0}">
        <div class="weui-panel">
            <div class="weui-panel__hd">已经结束的返校活动</div>
            <div class="weui-panel__bd">
                <c:forEach items="${activities[1]}" var="activity">
                    <a class="weui-media-box weui-media-box_text" style="display: block;"
                       href="${applicationScope.globalUrlPrefix}/wechat/alumni/back-school/${activity.id}">
                        <h4 class="weui-media-box__title">
                            <fmt:formatDate value="${activity.beginDate}" pattern="yyyy-MM-dd"/> 至 <fmt:formatDate
                                value="${activity.endDate}" pattern="yyyy-MM-dd"/>
                        </h4>
                        <ul class="weui-media-box__info">
                            <li class="weui-media-box__info__meta">返校人数${activity.alumniNum}人</li>
                            <li class="weui-media-box__info__meta weui-media-box__info__meta_extra">点击查看详情&nbsp;&gt;&gt;
                            </li>
                        </ul>
                    </a>
                </c:forEach>
            </div>
        </div>
    </c:if>
    <c:if test="${(not empty activities)&&(empty activities[1])&&(empty activities[2])&&(empty activities[3])}">
        <div class="weui-panel">
            <div class="weui-panel__bd">
                <!-- 当没有数据的时候 -->
                <div class="weui-loadmore weui-loadmore_line">
                    <span class="weui-loadmore__tips">暂无返校记录</span>
                </div>
            </div>
        </div>
    </c:if>
    <div class="weui-panel" style="margin-bottom: 20px;"></div>
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


