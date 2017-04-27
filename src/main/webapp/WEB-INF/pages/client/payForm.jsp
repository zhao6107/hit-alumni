<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>哈尔滨工业大学校友会</title>
    <style type="text/css" rel="stylesheet">
        table, tr, td {
            border: 2px solid #cccccc;
        }
    </style>
</head>
<body>
<div style="padding-left: 8px;">
    <h2>捐助信息</h2>
    捐助项目编号：<input type="text" value="${item.id}" readonly="readonly"><br>
    捐助项目名称：<input type="text" value="${item.body}" readonly="readonly"><br>
    输入捐助金额：<input type="number" id="donateMoney"><br>
    <button id="btn-sbt">提交</button>
</div>
<script src="http://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<script>
    $("#btn-sbt").click(function () {
        var targetUrl = "${targetUrl}";
        var redirectUrl = "${redirectUrl}";
        redirectUrl = redirectUrl + "?itemInfo=${item.body}_${item.detail}_" + $("#donateMoney").val() + "_web";
        redirectUrl = encodeURI(redirectUrl);
        targetUrl = targetUrl.replace("REDIRECT_URI", redirectUrl);
        window.location.href = targetUrl;
    });
</script>
</body>
</html>
