<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>哈尔滨工业大学校友会</title>
    <link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link rel="stylesheet" type="text/css" href="${applicationScope.globalUrlPrefix}/wechat/resources/css/common.css">
</head>
<body>
<form class="container js_container" action="#" method="post">
    <div class="hd">返校登记</div>
    <div class="weui-cells__title" style="margin-top: 30px;">基本信息</div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">姓　　名</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" name="alumniName" required="required" placeholder="请输入您的真实姓名"/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">入学年份</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="number" name="entryYear" placeholder="请输入您的入学年份"/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">班　　号</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" name="classNO" placeholder="请输入您的班级号码"/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">专业名称</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" name="major" placeholder="请输入您的专业名称"/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">院系名称</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" name="acadamy" placeholder="请输入您的院系名称"/>
            </div>
        </div>
        <div class="weui-cell weui-cell_select weui-cell_select-before">
            <div class="weui-cell__hd">
                <select class="weui-select" name="contactType">
                    <option value="1">手机</option>
                    <option value="2">微信</option>
                    <option value="3">Q Q</option>
                </select>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" name="contactInfo" required="required" placeholder="请输入相应联系方式"/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">工作单位</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" name="company" placeholder="请输入您的工作单位"/>
            </div>
        </div>
    </div>
    <div class="weui-btn-area" style="text-align: center;">
        <input class="weui-btn weui-btn_mini weui-btn_primary btn-c" value="提交" type="submit">
    </div>
</form>
</body>
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
    wx.ready(function () {
        wx.hideAllNonBaseMenuItem();
    });
</script>
</html>

