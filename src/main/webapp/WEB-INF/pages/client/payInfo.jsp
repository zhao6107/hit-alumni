<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>哈尔滨工业大学校友会</title>
    <link href="http://res.wx.qq.com/open/libs/weui/1.1.1/weui.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h2 style="padding-left: 20px;">捐款信息表单</h2>
<div style="padding-left: 20px;">
    捐款项目：<input type="text" name="itemName" readonly="readonly" value="${requestScope.simpleOrder.itemName}"><br>
    捐款金额：<input type="number" name="itemMoney" readonly="readonly" value="${requestScope.simpleOrder.itemMoney}"><br>
    详细描述：<input type="text" name="itemDetail" readonly="readonly" value="${requestScope.simpleOrder.itemDetail}"><br>
    <button onclick="payReady()">捐赠</button>
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

    function payReady() {
        wx.chooseWXPay({
            timestamp: ${requestScope.payInfo.timeStamp},
            nonceStr: '${requestScope.payInfo.nonceStr}',
            package: '${requestScope.payInfo.packageStr}',
            signType: '${requestScope.payInfo.signType}',
            paySign: '${requestScope.payInfo.paySign}',
            success: function (res) {
                // 支付成功后的回调函数
                alert(res.err_msg);
            }
        });
    }
</script>
</body>
</html>
