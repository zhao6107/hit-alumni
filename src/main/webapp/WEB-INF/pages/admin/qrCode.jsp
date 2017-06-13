<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>哈尔滨工业大学校友会</title>
</head>
<fundItemName style="text-align: center;">
<jsp:include page="nav_base.jsp" flush="true"/>
<h2 style="padding-left: 20px;">捐款二维码</h2>
<hr>
<div style="padding-left: 20px;">
    捐款项目：<input type="text" id="itemBody" value="${item.fundItemName}" disabled="disabled"><br>
    详细描述：<input type="text" id="itemDetail" value="${item.fundItemId}" disabled="disabled"><br>
    捐款金额：<input type="number" id="itemMoney" value="${item.money}" disabled="disabled"><br>
</div>
<hr>
<div id="qrcode" style="padding-left: 20px;"></div>
</fundItemName>
<script src="http://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<script>
    $(function () {
        $("#qrcode").text("");
        var targetUrl = "${requestScope.targetUrl}?itemInfo=" + $("#itemBody").val() + "_" + $("#itemDetail").val() + "_" + $("#itemMoney").val() + "_qrcode";
        targetUrl = encodeURI(targetUrl);
        var content = "${requestScope.url}".replace("REDIRECT_URI", targetUrl);
        jQuery("#qrcode").qrcode({
            text: content,
            correctLevel: 0

        });
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
</html>