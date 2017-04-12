<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>哈尔滨工业大学校友会</title>
    <!-- local resources -->
    <!-- create qr code -->
    <script src="../../resources/js/jquery.min.js"></script>
    <script src="../../resources/js/jquery.qrcode.min.js"></script>

    <!-- cdn resources -->
    <%--<script src="http://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>--%>
    <%--<script src="http://cdn.bootcss.com/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>--%>
</head>
<body>
<h2 style="padding-left: 20px;">捐款二维码生成器</h2>
<hr>
<div style="padding-left: 20px;">
    捐款项目：<input type="text" id="itemName"><br>
    详细描述：<input type="text" id="itemDetail"><br>
    捐款金额：<input type="number" id="itemMoney"><br>
    <button id="submit-btn">提交</button>
</div>
<hr>
<div id="qrcode" style="padding-left: 20px;"></div>
<script>
    $("#submit-btn").click(function () {
        $("#qrcode").text("");
        var targetUrl = "${requestScope.targetUrl}?itemInfo=" + $("#itemName").val() + "+" + $("#itemMoney").val() + "+" + $("#itemDetail").val();
        alert(encodeURI(targetUrl));
        jQuery("#qrcode").qrcode("${requestScope.url}".replace("REDIRECT_URI", encodeURI(targetUrl)));
    });
</script>
</body>
</html>