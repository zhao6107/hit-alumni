<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>哈工大校友会</title>
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
<form action="/qrcode/create" method="post" style="padding-left: 20px;">
    捐款项目：<input type="text" name="itemName"><br>
    捐款金额：<input type="number" name="itemMoney"><br>
    详细描述：<input type="text" name="itemDetail"><br>
    <input type="submit" value="提交">
</form>
<hr>
<div style="padding-left: 20px;">
    捐款项目：<input type="text" id="itemName"><br>
    捐款金额：<input type="number" id="itemMoney"><br>
    详细描述：<input type="text" id="itemDetail"><br>
    <button id="submit-btn">提交</button>
</div>
<hr>
<div id="qrcode" style="padding-left: 20px;"></div>
<script>
    $("#submit-btn").click(function () {
        $("#qrcode").text("");
        var itemName = $("#itemName").val();
        var itemMoney = $("#itemMoney").val();
        var itemDetail = $("#itemDetail").val();
        jQuery("#qrcode").qrcode("http://hit-alumni.tunnel.qydev.com/donate/info?itemName=" + itemName + "&itemMoney=" + itemMoney + "&itemDetail=" + itemDetail);
    });
</script>
</body>
</html>