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
        var targetUrl = "${requestScope.targetUrl}?itemInfo=" + $("#itemName").val() + "_" + $("#itemMoney").val() + "_" + $("#itemDetail").val();
        var content = "${requestScope.url}".replace("REDIRECT_URI", targetUrl);
        jQuery("#qrcode").qrcode(content);
    });

    //用于只将中文内容转为utf-8 --->没用啊！
    function toUtf8(str) {
        var out, i, len, c;
        out = "";
        len = str.length;
        for (i = 0; i < len; i++) {
            c = str.charCodeAt(i);
            if ((c >= 0x0001) && (c <= 0x007F)) {
                out += str.charAt(i);
            } else if (c > 0x07FF) {
                out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
                out += String.fromCharCode(0x80 | ((c >> 6) & 0x3F));
                out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
            } else {
                out += String.fromCharCode(0xC0 | ((c >> 6) & 0x1F));
                out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
            }
        }
        return out;
    }
</script>
</body>
</html>