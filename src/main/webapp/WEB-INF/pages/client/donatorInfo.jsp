<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes"/>
    <title>哈尔滨工业大学校友会</title>
</head>
<body>
<div style="padding-left: 8px">
    <h2>做好事要留名奥</h2>
    <hr>
    捐助说明：<input type="text" id="comment"><br>
    是否匿名：
    <select id="isAnonymous">
        <option value="0">否</option>
        <option value="1">是</option>
    </select>
    <form action="/donate/donator-info" method="post" id="donator-info">
        <input type="hidden" name="out_trade_no" value="${out_trade_no}">
        <input type="hidden" name="comment" id="comment_">
        真实姓名：<input type="text" name="trueName" id="trueName"><br>
        手机号码：<input type="text" name="phone"><br>
        班级号码：<input type="text" name="classNO"><br>
        入学年份：<input type="text" name="entryYear"><br>
        专业名称：<input type="text" name="major"><br>
        邮寄地址：<input type="text" name="mailAddr"><br>
        公司单位：<input type="text" name="company"><br>
        工作岗位：<input type="text" name="job"><br>
        <input type="submit" value="提交">
    </form>
</div>
<script src="http://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<script>
    $("#isAnonymous").change(function () {
        if ($("#isAnonymous").val() == 1) {
            $("#trueName").val("匿名");
            $("#donator-info input").each(function () {
                $(this).attr("readonly", "readonly");
            });
        } else {
            $("#donator-info input").each(function () {
                $(this).removeAttr("readonly");
            });
        }
    });

    $("#comment").blur(function () {
        $("#comment_").val($("#comment").val());
    });
</script>
</body>
</html>