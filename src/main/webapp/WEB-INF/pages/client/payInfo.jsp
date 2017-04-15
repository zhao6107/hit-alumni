<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" /> 
    <title>哈尔滨工业大学校友会</title>
    <script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
</head>
<body>
<h2 style="padding-left: 20px;">捐款信息表单</h2>
<div style="padding-left: 20px;">
    捐款项目：<input type="text" name="itemName" readonly="readonly" value="${requestScope.simpleOrder.itemName}"><br>
    捐款金额：<input type="number" name="itemMoney" readonly="readonly" value="${requestScope.simpleOrder.itemMoney}"><br>
    详细描述：<input type="text" name="itemDetail" readonly="readonly" value="${requestScope.simpleOrder.itemDetail}"><br>
    <button onclick="payReady()">捐赠</button>
</div>
<script>
//    wx.config({
//        debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
//        appId: '', // 必填，公众号的唯一标识
//        timestamp:214 , // 必填，生成签名的时间戳
//        nonceStr: '', // 必填，生成签名的随机串
//        signature: '',// 必填，签名，见附录1
//        jsApiList: [] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
//    });

	function payReady(){
		wx.chooseWXPay({
			timeStamp: ${requestScope.payInfo.timeStamp}, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
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
