<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>哈尔滨工业大学校友会</title>
</head>
<body>
<h2 style="padding-left: 20px;">捐款信息表单</h2>
<form action="/test/pay" method="post">
    捐款项目：<input type="text" name="itemName" readonly="readonly" value="${requestScope.itemName}"><br>
    捐款金额：<input type="number" name="itemMoney" readonly="readonly" value="${requestScope.itemMoney}"><br>
    详细描述：<input type="text" name="itemDetail" readonly="readonly" value="${requestScope.itemDetail}"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
