<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes"/>
    <title>哈尔滨工业大学校友会</title>
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
            timestamp: ${requestScope.payInfo.timeStamp}, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
            nonceStr: '${requestScope.payInfo.nonceStr}', // 支付签名随机串，不长于 32 位
            package: '${requestScope.payInfo.packageStr}', // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
            signType: '${requestScope.payInfo.signType}', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
            paySign: '${requestScope.payInfo.paySign}', // 支付签名
            success: function (res) {
                // 支付成功后的回调函数
                alert(res.err_msg);
            }
        });
    }
</script>
</body>
</html>
