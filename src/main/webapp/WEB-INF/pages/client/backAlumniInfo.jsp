<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>哈尔滨工业大学校友会</title>
    <link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link rel="stylesheet" type="text/css" href="${applicationScope.globalUrlPrefix}/wechat/resources/css/common.css">
</head>
<body>
<form class="container js_container" action="${applicationScope.globalUrlPrefix}/wechat/alumni/back-school"
      method="post">
    <input type="hidden" name="openId" value="${openId}">
    <div class="hd">1/2　返校登记</div>
    <div class="weui-cells__title" style="margin-top: 30px;">基本信息</div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell" id="div-0">
            <div class="weui-cell__hd"><label class="weui-label">姓　　名</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" name="name" required="required" placeholder="请输入您的真实姓名"
                       value="${alumni.name}"/>
            </div>
        </div>
        <div class="weui-cell" id="div-1">
            <div class="weui-cell__hd"><label class="weui-label">入学年份</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="number" name="entryYear" placeholder="请输入您的入学年份"
                       value="${alumni.entryYear}"/>
            </div>
        </div>
        <div class="weui-cell" id="div-2">
            <div class="weui-cell__hd"><label class="weui-label">班　　号</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" name="classNO" placeholder="请输入您的班级号码" value="${alumni.classNO}"/>
            </div>
        </div>
        <div class="weui-cell" id="div-3">
            <div class="weui-cell__hd"><label class="weui-label">专业名称</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" name="major" placeholder="请输入您的专业名称" value="${alumni.major}"/>
            </div>
        </div>
        <!--
        <div class="weui-cell" id="div-4">
            <div class="weui-cell__hd"><label class="weui-label">院系名称</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" name="academy" placeholder="请输入您的院系名称"/>
            </div>
        </div>
         -->
        <input type="hidden" name="academy"/>
        <div class="weui-cell weui-cell_select weui-cell_select-before" id="div-5">
            <div class="weui-cell__hd">
                <select class="weui-select" name="contactType">
                    <option value="1">手机</option>
                    <option value="2">微信</option>
                    <option value="3">Q Q</option>
                </select>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" name="contactInfo" required="required" placeholder="请输入相应联系方式"
                       value="${alumni.contactInfo}"/>
            </div>
        </div>
        <div class="weui-cell" id="div-6">
            <div class="weui-cell__hd"><label class="weui-label">工作单位</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" name="company" placeholder="请输入您的工作单位" value="${alumni.company}"/>
            </div>
        </div>
        <div class="weui-cell" id="div-7">
            <div class="weui-cell__hd"><label class="weui-label">职　　位</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" name="job" placeholder="请输入您的工作职位" value="${alumni.job}"/>
            </div>
        </div>
    </div>
    <div class="weui-btn-area" style="text-align: center;" id="btn-div">
        <c:if test="${empty alumni}">
            <input class="weui-btn weui-btn_mini weui-btn_primary btn-c" value="提交信息" type="submit">
        </c:if>
    </div>
</form>
<c:if test="${not empty alumni}">
    <div style="text-align: center;">
        <a class="weui-btn weui-btn_mini weui-btn_default" id="btn0">修改信息</a>
        <a class="weui-btn weui-btn_mini weui-btn_primary btn-c" id="btn1"
           href="${applicationScope.globalUrlPrefix}/wechat/alumni/back-school/activity?openId=${openId}">确认信息</a>
    </div>
</c:if>
</body>
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
    wx.ready(function () {
        wx.hideAllNonBaseMenuItem();
    });

    $(function () {
        var number = '${alumni.contactType}';
        if (number == '1' || number == '2' || number == '3') {
            $('select[name="contactType"]').val(number);
        }
    });

    $("#btn0").click(function () {
        $("input").each(function () {
            $(this).removeAttr("readonly");
            $(this).removeAttr("disabled");
        });
        for (var i = 0; i < 8; i++) {
            $("#div-" + i).removeClass("input-disabled");
        }
        $("#btn-div").append('<input class="weui-btn weui-btn_mini weui-btn_primary btn-c" value="提交信息" type="submit">');
        $(this).hide();
        $("#btn1").hide();
    });

    //页面初始化
    <c:if test="${not empty alumni}">
    $(function () {
        //设置所有input为disabled
        $("input").each(function () {
            $(this).attr("readonly", "readonly");
            $(this).attr("disabled", "true");
        });
        for (var i = 0; i < 8; i++) {
            $("#div-" + i).addClass("input-disabled");
        }
    });
    </c:if>
</script>
</html>

