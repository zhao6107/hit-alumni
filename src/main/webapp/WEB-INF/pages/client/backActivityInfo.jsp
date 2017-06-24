<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>哈尔滨工业大学校友会</title>
    <link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link rel="stylesheet" type="text/css" href="${applicationScope.globalUrlPrefix}/hit-alumni/wechat/css/common.css">
</head>
<body>
<form class="container js_container" action="${applicationScope.globalUrlPrefix}/hit-alumni/wechat/alumni/back-school"
      method="post">
    <c:if test="${not empty activity}">
        <input type="hidden" name="openId" value="${activity.openId}">
        <input type="hidden" name="id" value="${activity.id}">
    </c:if>
    <c:if test="${empty activity}">
        <input type="hidden" name="openId" value="${openId}">
    </c:if>
    <div class="hd">
        <c:choose>
            <c:when test="${empty activity}">2/2 返校需求</c:when>
            <c:otherwise>返校信息</c:otherwise>
        </c:choose>
    </div>
    <div class="weui-cells__title" style="margin-top: 30px;">基本信息</div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell" id="div-0">
            <div class="weui-cell__hd"><label class="weui-label">起始日期</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="date" name="beginDate" required="required"
                       value="<fmt:formatDate value='${activity.beginDate}' pattern='yyyy-MM-dd'/>"/>
            </div>
        </div>
        <div class="weui-cell" id="div-1">
            <div class="weui-cell__hd"><label class="weui-label">结束日期</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="date" name="endDate" required="required"
                       value="<fmt:formatDate value='${activity.endDate}' pattern='yyyy-MM-dd'/>"/>
            </div>
        </div>
        <div class="weui-cell" id="div-2">
            <div class="weui-cell__hd"><label class="weui-label">返校人数</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="number" name="alumniNum" required="required"
                       value="${activity.alumniNum}" placeholder="请输入此次返校人数"/>
            </div>
        </div>
    </div>
    <div class="weui-cells__title" style="margin-top: 30px;">校史馆参观</div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell weui-cell_switch" id="item-0-div-0">
            <div class="weui-cell__bd">是否参观</div>
            <div class="weui-cell__ft">
                <input class="weui-switch" type="checkbox" id="item-0-visited"/>
            </div>
        </div>
        <!--处理参观校史馆的时间-->
        <c:if test="${not empty activity && not empty activity.historyMuseumVisitedDate}">
            <div class="weui-cell weui-cell_switch" id="item-0-div-1">
                <div class="weui-cell__bd">校友会代预约</div>
                <div class="weui-cell__ft"><input class="weui-switch" type="checkbox" id="item-0-bookProxyed"/></div>
            </div>
            <div class="weui-cell" id="item-0-div-2">
                <div class="weui-cell__hd"><label class="weui-label">参观时间</label></div>
                <div class="weui-cell__bd"><input class="weui-input" type="datetime-local"
                                                  value="<fmt:formatDate value='${activity.historyMuseumVisitedDate}' pattern='yyyy-MM-dd\'T\'HH:mm'/>"
                                                  name="historyMuseumVisitedDate" required="required"/></div>
            </div>
        </c:if>
    </div>
    <input id="hidden-input-0" type="hidden" value="0"/>
    <div class="weui-cells__tips">预约方式见官网 <a href="http://www.museum.hit.edu.cn">www.museum.hit.edu.cn</a></div>

    <div class="weui-cells__title" style="margin-top: 30px;">航天馆参观</div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell weui-cell_switch" id="item-1-div-0">
            <div class="weui-cell__bd">是否参观</div>
            <div class="weui-cell__ft">
                <input class="weui-switch" type="checkbox" id="item-1-visited"/>
            </div>
        </div>
        <!--处理参观航天馆的时间-->
        <c:if test="${not empty activity && not empty activity.astronauticsMuseumVisitedDate}">
            <div class="weui-cell weui-cell_switch" id="item-1-div-1">
                <div class="weui-cell__bd">校友会代预约</div>
                <div class="weui-cell__ft"><input class="weui-switch" type="checkbox" id="item-1-bookProxyed"/></div>
            </div>
            <div class="weui-cell" id="item-1-div-2">
                <div class="weui-cell__hd"><label class="weui-label">参观时间</label></div>
                <div class="weui-cell__bd"><input class="weui-input" type="datetime-local"
                                                  value="<fmt:formatDate value='${activity.astronauticsMuseumVisitedDate}' pattern='yyyy-MM-dd\'T\'HH:mm'/>"
                                                  name="astronauticsMuseumVisitedDate" required="required"/></div>
            </div>
        </c:if>
    </div>
    <input id="hidden-input-1" type="hidden" value="0"/>
    <div class="weui-cells__tips">预约方式见官网 <a href="http://hitam.aajp.net">hitam.aajp.net</a></div>

    <div class="weui-cells__title" style="margin-top: 30px;">博物馆参观</div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell weui-cell_switch" id="item-2-div-0">
            <div class="weui-cell__bd">是否参观</div>
            <div class="weui-cell__ft">
                <input class="weui-switch" type="checkbox" id="item-2-visited"/>
            </div>
        </div>
        <!--处理参观博物馆的时间-->
        <c:if test="${not empty activity && not empty activity.schoolMuseumVisitedDate}">
            <div class="weui-cell weui-cell_switch" id="item-2-div-1">
                <div class="weui-cell__bd">校友会代预约</div>
                <div class="weui-cell__ft"><input class="weui-switch" type="checkbox" id="item-2-bookProxyed"/></div>
            </div>
            <div class="weui-cell" id="item-2-div-2">
                <div class="weui-cell__hd"><label class="weui-label">参观时间</label></div>
                <div class="weui-cell__bd"><input class="weui-input" type="datetime-local" value="<fmt:formatDate
                value='${activity.schoolMuseumVisitedDate}'
                pattern='yyyy-MM-dd\'T\'HH:mm'/>" name="schoolMuseumVisitedDate" required="required"/></div>
            </div>
        </c:if>
    </div>
    <input id="hidden-input-2" type="hidden" value="0"/>
    <div class="weui-cells__tips">预约方式见官网 <a href="http://www.museum.hit.edu.cn">www.museum.hit.edu.cn</a></div>

    <div class="weui-cells__title" style="margin-top: 30px;">其他需求</div>
    <div class="weui-cells weui-cells_form">
        <!--
        <div class="weui-cell weui-cell_switch" id="div-3">
            <div class="weui-cell__bd">对接校友总会</div>
            <div class="weui-cell__ft">
                <input class="weui-switch" type="checkbox" id="switch-btn-0" />
            </div>
        </div>
         -->
        <input type="hidden" name="meetAlumniAssociation" value="${activity.meetAlumniAssociation}"/>
        <div class="weui-cell weui-cell_switch" id="div-4">
            <div class="weui-cell__bd">接受学校采访</div>
            <div class="weui-cell__ft">
                <input class="weui-switch" type="checkbox" id="switch-btn-1"/>
                <input type="hidden" name="acceptInterview" value="${activity.acceptInterview}"/>
            </div>
        </div>
        <div class="weui-cell weui-cell_switch" id="div-5">
            <div class="weui-cell__bd">给在校生开讲座</div>
            <div class="weui-cell__ft">
                <input class="weui-switch" type="checkbox" id="switch-btn-2"/>
                <input type="hidden" name="giveLecture" value="${activity.giveLecture}"/>
            </div>
        </div>
        <div class="weui-cell weui-cell_switch" id="div-6">
            <div class="weui-cell__bd">志愿者帮助拍照</div>
            <div class="weui-cell__ft">
                <input class="weui-switch" type="checkbox" id="switch-btn-3"/>
                <input type="hidden" name="needVolunteer" value="${activity.needVolunteer}"/>
            </div>
        </div>
    </div>
    <div class="weui-cells__tips">除寒暑假外可提供志愿者服务</div>
    <div class="weui-btn-area" style="text-align: center;" id="sbt-div">
        <c:if test="${empty activity}">
            <input class="weui-btn weui-btn_mini weui-btn_primary btn-c" type="submit" value="提交"/>
        </c:if>
    </div>
</form>
<jsp:useBean id="nowDate" class="java.util.Date"/>
<c:if test="${not empty activity && (nowDate.time < activity.endDate.time)}">
    <div style="text-align: center;margin-bottom: 20px;">
        <button class="weui-btn weui-btn_mini weui-btn_primary btn-c" id="modify-btn">我要修改信息</button>
    </div>
</c:if>
</body>
<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script src="http://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<script>
    //微信js sdk设置
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

    //关于网页中按钮动作的状态记录变量
    var item0Chosen = 0;//是否参观校史馆，0不参观，1参观
    var item1Chosen = 0;//是否参观航天馆，0不参观，1参观
    var item2Chosen = 0;//是否参观博物馆，0不参观，1参观
    var item0Chosen_ = 0;//确定参观校史馆，是否需要校友办公室帮助预约，0不需要，1需要
    var item1Chosen_ = 0;//确定参观航天馆，是否需要校友办公室帮助预约，0不需要，1需要
    var item2Chosen_ = 0;//确定参观博物馆，是否需要校友办公室帮助预约，0不需要，1需要
    var switchBtn0Chosen = 0;//是否对接校友总会，0否，1是
    var switchBtn1Chosen = 0;//是否接受学校采访，0否，1是
    var switchBtn2Chosen = 0;//是否给在校生开讲座，0否，1是
    var switchBtn3Chosen = 0;//是否需要志愿者帮助拍照等，0否，1是

    /********************************
     以下函数定义用于新建返校信息时使用
     ********************************/
    //当新建返校活动时，初始表单中的日期项
    function initPageWhenAdd() {
        getShowDelayDate(7, "beginDate");
        getShowDelayDate(8, "endDate");
    }
    //初始化日期表单中的日期内容
    function getShowDelayDate(delayDays, inputName) {
        var curDate = new Date();
        var year = curDate.getFullYear();
        var month = curDate.getMonth() + 1;
        var date = curDate.getDate();
        if ((date + delayDays) > 28) {//跨月
            date = (date + delayDays) % 28;//显示的日期中的日
            if (month == 12) {//跨年
                month = 1;//显示日期中的月
                year = year + 1;//显示日期中的年
            } else {
                month = month + 1;//显示日期中的月
            }
        } else {
            date = date + delayDays;//显示日期中的日
        }
        $("input[name='" + inputName + "']").val(year + "-" + ((month > 9) ? month : ("0" + month)) + "-" + ((date > 9) ? date : ("0" + date)));
    }
    //关于参观校史馆的按钮动作
    $("#item-0-visited").change(function () {
        if (item0Chosen == 0) {
            item0Chosen = 1;
            var div = '<div class="weui-cell weui-cell_switch" id="item-0-div-1"><div class="weui-cell__bd">校友会代预约</div><div class="weui-cell__ft"><input class="weui-switch" type="checkbox" id="item-0-bookProxyed"/></div></div>';
            $("#item-0-div-0").after(div);
            $("#item-0-bookProxyed").change(function () {
                if (item0Chosen_ == 0) {
                    item0Chosen_ = 1;
                    var div_ = '<div class="weui-cell" id="item-0-div-2"><div class="weui-cell__hd"><label for="" class="weui-label">参观时间</label></div><div class="weui-cell__bd"><input class="weui-input" type="datetime-local" value="" name="historyMuseumVisitedDate" required="required"/></div></div>';
                    $("#item-0-div-1").after(div_);
                    $("#hidden-input-0").val(1);
                } else {
                    item0Chosen_ = 0;
                    $("#item-0-div-2").remove();
                    $("#hidden-input-0").val(0);
                }
            });
        } else {
            item0Chosen = 0;
            item0Chosen_ = 0;
            $("#item-0-div-1").remove();
            $("#item-0-div-2").remove();
            $("#hidden-input-0").val(0);
        }
    });
    //关于参观航天馆的按钮动作
    $("#item-1-visited").change(function () {
        if (item1Chosen == 0) {
            item1Chosen = 1;
            var div = '<div class="weui-cell weui-cell_switch" id="item-1-div-1"><div class="weui-cell__bd">校友会代预约</div><div class="weui-cell__ft"><input class="weui-switch" type="checkbox" id="item-1-bookProxyed"/></div></div>';
            $("#item-1-div-0").after(div);
            $("#item-1-bookProxyed").change(function () {
                if (item1Chosen_ == 0) {
                    item1Chosen_ = 1;
                    var div_ = '<div class="weui-cell" id="item-1-div-2"><div class="weui-cell__hd"><label for="" class="weui-label">参观时间</label></div><div class="weui-cell__bd"><input class="weui-input" type="datetime-local" value="" name="astronauticsMuseumVisitedDate" required="required" /></div></div>';
                    $("#item-1-div-1").after(div_);
                    $("#hidden-input-1").val(1);
                } else {
                    item1Chosen_ = 0;
                    $("#item-1-div-2").remove();
                    $("#hidden-input-1").val(0);
                }
            });
        } else {
            item1Chosen = 0;
            item1Chosen_ = 0;
            $("#item-1-div-1").remove();
            $("#item-1-div-2").remove();
            $("#hidden-input-1").val(0);
        }
    });
    //关于参观博物馆的按钮动作
    $("#item-2-visited").change(function () {
        if (item2Chosen == 0) {
            item2Chosen = 1;
            var div = '<div class="weui-cell weui-cell_switch" id="item-2-div-1"><div class="weui-cell__bd">校友会代预约</div><div class="weui-cell__ft"><input class="weui-switch" type="checkbox" id="item-2-bookProxyed"/></div></div>';
            $("#item-2-div-0").after(div);
            $("#item-2-bookProxyed").change(function () {
                if (item2Chosen_ == 0) {
                    item2Chosen_ = 1;
                    var div_ = '<div class="weui-cell" id="item-2-div-2"><div class="weui-cell__hd"><label for="" class="weui-label">参观时间</label></div><div class="weui-cell__bd"><input class="weui-input" type="datetime-local" value="" name="schoolMuseumVisitedDate" required="required" /></div></div>';
                    $("#item-2-div-1").after(div_);
                    $("#hidden-input-2").val(1);
                } else {
                    item2Chosen_ = 0;
                    $("#item-2-div-2").remove();
                    $("#hidden-input-2").val(0);
                }
            });
        } else {
            item2Chosen = 0;
            item2Chosen_ = 0;
            $("#item-2-div-1").remove();
            $("#item-2-div-2").remove();
            $("#hidden-input-2").val(0);
        }
    });
    //是否对接校友总会
    $("#switch-btn-0").change(function () {
        if (switchBtn0Chosen == 0) {
            switchBtn0Chosen = 1;
            $("input[name='meetAlumniAssociation']").val(1);
        } else {
            switchBtn0Chosen = 0;
            $("input[name='meetAlumniAssociation']").val(0);
        }
    });
    //是否接受学校采访
    $("#switch-btn-1").change(function () {
        if (switchBtn1Chosen == 0) {
            switchBtn1Chosen = 1;
            $("input[name='acceptInterview']").val(1);
        } else {
            switchBtn1Chosen = 0;
            $("input[name='acceptInterview']").val(0);
        }
    });
    //是否给在校生开讲座
    $("#switch-btn-2").change(function () {
        if (switchBtn2Chosen == 0) {
            switchBtn2Chosen = 1;
            $("input[name='giveLecture']").val(1);
        } else {
            switchBtn2Chosen = 0;
            $("input[name='giveLecture']").val(0);
        }
    });
    //是否需要志愿者提供帮助
    $("#switch-btn-3").change(function () {
        if (switchBtn3Chosen == 0) {
            switchBtn3Chosen = 1;
            $("input[name='needVolunteer']").val(1);
        } else {
            switchBtn3Chosen = 0;
            $("input[name='needVolunteer']").val(0);
        }
    });

    /********************************
     以下函数定义用于修改返校信息时使用
     ********************************/
    function initPageWhenUpdate() {
        //处理参观校史馆的时间
        var tmp = $("input[name='historyMuseumVisitedDate']").val();
        if (typeof(tmp) != "undefined" && tmp != "") {
            item0Chosen = 1;
            $("#item-0-visited").attr("checked", "checked");
            item0Chosen_ = 1;
            $("#item-0-bookProxyed").attr("checked", "checked");
            $("#hidden-input-0").val(1);
        }
        //处理参观航天馆的时间
        tmp = $("input[name='astronauticsMuseumVisitedDate']").val();
        if (typeof(tmp) != "undefined" && tmp != "") {
            item1Chosen = 1;
            $("#item-1-visited").attr("checked", "checked");
            item1Chosen_ = 1;
            $("#item-1-bookProxyed").attr("checked", "checked");
            $("#hidden-input-1").val(1);
        }
        //处理参观博物馆的时间
        tmp = $("input[name='schoolMuseumVisitedDate']").val();
        if (typeof(tmp) != "undefined" && tmp != "") {
            item2Chosen = 1;
            $("#item-2-visited").attr("checked", "checked");
            item2Chosen_ = 1;
            $("#item-2-bookProxyed").attr("checked", "checked");
            $("#hidden-input-2").val(1);
        }

        //是否对接校友总会
        if ($("input[name='meetAlumniAssociation']").val() == 1) {
            $("#switch-btn-0").attr("checked", "checked");
            switchBtn0Chosen = 1;
        }
        //是否接受学校采访
        if ($("input[name='acceptInterview']").val() == 1) {
            $("#switch-btn-1").attr("checked", "checked");
            switchBtn1Chosen = 1;
        }
        //是否给在校生开讲座
        if ($("input[name='giveLecture']").val() == 1) {
            $("#switch-btn-2").attr("checked", "checked");
            switchBtn2Chosen = 1;
        }
        //是否需要志愿者提供帮助
        if ($("input[name='needVolunteer']").val() == 1) {
            $("#switch-btn-3").attr("checked", "checked");
            switchBtn3Chosen = 1;
        }

        //设置所有input为disabled
        $("input").each(function () {
            $(this).attr("readonly", "readonly");
            $(this).attr("disabled", "true");
        });
        for (var i = 0; i < 7; i++) {
            $("#div-" + i).addClass("input-disabled");
        }
        for (var i = 0; i < 3; i++) {
            for (var j = 0; j < 3; j++) {
                $("#item-" + i + "-div-" + j).addClass("input-disabled");
            }
        }
    }

    //点击修改按钮，表单域变得可以修改
    $("#modify-btn").click(function () {
        $("input").each(function () {
            $(this).removeAttr("readonly");
            $(this).removeAttr("disabled");
        });
        for (var i = 0; i < 7; i++) {
            $("#div-" + i).removeClass("input-disabled");
        }
        for (var i = 0; i < 3; i++) {
            for (var j = 0; j < 3; j++) {
                $("#item-" + i + "-div-" + j).removeClass("input-disabled");
            }
        }
        $("#sbt-div").append('<input class="weui-btn weui-btn_mini weui-btn_primary btn-c" type="submit" value="修改"/>');
        $(this).hide();
    });


    //页面初始化
    <c:choose>
    <c:when test="${not empty activity}">
    $(function () {
        initPageWhenUpdate();
    });
    </c:when>
    <c:otherwise>
    $(function () {
        initPageWhenAdd();
    });
    </c:otherwise>
    </c:choose>
</script>
</html>

