<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>哈尔滨工业大学校友会</title>
    <link href="http://res.wx.qq.com/open/libs/weui/1.1.1/weui.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h2 style="padding-left: 8px">捐款信息表单</h2>
<div style="padding-left: 8px">
    捐款项目：<input type="text" name="itemName" readonly="readonly" value="${requestScope.simpleOrder.itemName}"><br>
    捐款金额：<input type="number" name="itemMoney" readonly="readonly" value="${requestScope.simpleOrder.itemMoney}"><br>
    详细描述：<input type="text" name="itemDetail" readonly="readonly" value="${requestScope.simpleOrder.itemDetail}"><br>
    <hr>
    捐助说明：<input type="text" id="comment"><br>
    是否匿名：
    <select id="isAnonymous">
        <option value="0">否</option>
        <option value="1">是</option>
    </select>
    <div id="donator-info">
        真实姓名：<input type="text" id="trueName"><br>
        手机号码：<input type="text" id="phone"><br>
        班级号码：<input type="text" id="classNO"><br>
        入学年份：<input type="text" id="entryYear"><br>
        专业名称：<input type="text" id="major"><br>
        邮寄地址：<input type="text" id="mailAddr"><br>
        公司单位：<input type="text" id="company"><br>
        工作岗位：<input type="text" id="job">
    </div>
    <hr>
    <button id="btn-sbt">捐赠</button>
</div>
<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script src="http://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<script>
    wx.config({
        debug: ${requestScope.jsSdkConfig.debug},
        appId: '${requestScope.jsSdkConfig.appId}',
        timestamp:${requestScope.jsSdkConfig.timestamp},
        nonceStr: '${requestScope.jsSdkConfig.nonceStr}',
        signature: '${requestScope.jsSdkConfig.signature}',
        jsApiList: ${requestScope.jsSdkConfig.jsApiList}
    });

    $("#isAnonymous").change(function () {
        if ($("#isAnonymous").val() == 1) {
            $("#donator-info input").each(function () {
                $(this).attr("readonly", "readonly");
            });
        } else {
            $("#donator-info input").each(function () {
                $(this).removeAttr("readonly");
            });
        }
    });

    $("#btn-sbt").click(function () {
        wx.chooseWXPay({
            timestamp: ${requestScope.payInfo.timeStamp},
            nonceStr: '${requestScope.payInfo.nonceStr}',
            package: '${requestScope.payInfo.packageStr}',
            signType: '${requestScope.payInfo.signType}',
            paySign: '${requestScope.payInfo.paySign}',
            success: function () {
                var _trueName = "匿名";
                if ($("#isAnonymous").val() == 0) {
                    _trueName = $("#trueName").val();
                }
                $.ajax({
                    async: false,
                    type: "POST",
                    url: "${requestScope.serverUrl}/donate/donator-info",
                    data: {
                        "out_trade_no": "${requestScope.out_trade_no}",
                        "comment": $("#comment").val(),
                        "trueName": _trueName,
                        "phone": $("#phone").val(),
                        "classNO": $("#classNO").val(),
                        "entryYear": $("#entryYear").val(),
                        "major": $("#major").val(),
                        "mailAddr": $("#mailAddr").val(),
                        "company": $("#company").val(),
                        "job": $("#job").val()
                    },
                    dataType: "json",
                    contentType: "application/x-www-form-urlencoded",
                    success: function (result) {
                        if (result == "1") {
                            window.location.href = "${requestScope.serverUrl}/donate/result?out_trade_no=${requestScope.out_trade_no}";
                        }
                    }
                });
            }
        });
    });
</script>
</body>
</html>
