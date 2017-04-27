<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>哈尔滨工业大学校友会</title>
</head>
<body>
<p style="padding-left: 8px;">正在跳转中...</p>
<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script>
    var time = 3;
    autoJump();

    function autoJump() {
        setTimeout("autoJump()", 1000)
        time = time - 1;
        if (time == 0) {
            readyPay();
        }
    }

    wx.config({
        debug: ${requestScope.jsSdkConfig.debug},
        appId: '${requestScope.jsSdkConfig.appId}',
        timestamp:${requestScope.jsSdkConfig.timestamp},
        nonceStr: '${requestScope.jsSdkConfig.nonceStr}',
        signature: '${requestScope.jsSdkConfig.signature}',
        jsApiList: ${requestScope.jsSdkConfig.jsApiList}
    });

    function readyPay() {
        wx.chooseWXPay({
            timestamp: ${requestScope.payInfo.timeStamp},
            nonceStr: '${requestScope.payInfo.nonceStr}',
            package: '${requestScope.payInfo.packageStr}',
            signType: '${requestScope.payInfo.signType}',
            paySign: '${requestScope.payInfo.paySign}',
            success: function () {
                window.location.href = "/donate/donator-info?out_trade_no=${out_trade_no}"
            }
        });
    }
</script>
</body>
</html>
