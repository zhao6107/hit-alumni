<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>哈尔滨工业大学校友会</title>
    <link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link rel="stylesheet" type="text/css" href="${applicationScope.globalUrlPrefix}/hitef/wechat/css/base.css">
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
            <p class="weui-msg__desc">感谢您的捐赠,下方领取您的捐赠证书吧。</p>
        </c:if>
    </div>
</div>
<c:if test="${!empty out_trade_no}">
    <img style="width: 100%;height: auto;display: block;"
         src="${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg">
    <div style="margin-top: 5px;margin-left: 10px;text-align:left;font-size: 14px;color: #999;">温馨提示：点击右上角中分享按钮可实现分享。</div>
</c:if>
</body>
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
        //隐藏全部菜单项
        wx.hideAllNonBaseMenuItem();
        //显示指定的菜单项
        wx.showMenuItems({
            menuList: ['menuItem:share:appMessage', 'menuItem:share:timeline', 'menuItem:share:qq', 'menuItem:share:QZone']
        });
        //分享给微信朋友
        wx.onMenuShareAppMessage({
            title: '我参与了为母校哈工大捐款的活动，你有我捐得多吗？→ →',
            desc: '尽一份微薄之力，助力母校腾飞！',
            link: '${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg',
            imgUrl: '${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg',
        });
        //分享到微信朋友圈
        wx.onMenuShareTimeline({
            title: '我参与了为母校哈工大捐款的活动，你有我捐得多吗？→ →',
            link: '${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg',
            imgUrl: '${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg',
        });
        //分享给QQ朋友
        wx.onMenuShareQQ({
            title: '我参与了为母校哈工大捐款的活动，你有我捐得多吗？→ →',
            desc: '尽一份微薄之力，助力母校腾飞！',
            link: '${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg',
            imgUrl: '${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg',
        });
        //分享到QQ空间
        wx.onMenuShareQZone({
            title: '我参与了为母校哈工大捐款的活动，你有我捐得多吗？→ →',
            desc: '尽一份微薄之力，助力母校腾飞！',
            link: '${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg',
            imgUrl: '${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg',
        });
    });
</script>
</html>
