<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>哈尔滨工业大学校友会</title>
    <link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css">
    <link rel="stylesheet" type="text/css" href="${applicationScope.globalUrlPrefix}/wechat/resources/css/common.css">
</head>
<body>
<form class="container js_container" action="${applicationScope.globalUrlPrefix}/wechat/alumni/back-school" method="post">
    <input type="hidden" name="openId" value="${openId}">
    <div class="hd">2/2 返校需求</div>
    <div class="weui-cells__title" style="margin-top: 30px;">基本信息</div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">起始日期</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="date" name="beginDate" required="required"/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">结束日期</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="date" name="endDate" required="required"/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">返校人数</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" name="alumniNum" required="required" placeholder="请输入此次返校人数"/>
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
    </div>
    <input id="hidden-input-0" type="hidden" name="item[0].bookProxyed" value="0"/>
    <div class="weui-cells__tips">预约方式见官网 <a href="http://www.museum.hit.edu.cn">www.museum.hit.edu.cn</a></div>

    <div class="weui-cells__title" style="margin-top: 30px;">航天馆参观</div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell weui-cell_switch" id="item-1-div-0">
            <div class="weui-cell__bd">是否参观</div>
            <div class="weui-cell__ft">
                <input class="weui-switch" type="checkbox" id="item-1-visited"/>
            </div>
        </div>
    </div>
    <input id="hidden-input-1" type="hidden" name="item[1].bookProxyed" value="0"/>
    <div class="weui-cells__tips">预约方式见官网 <a href="http://hitam.aajp.net">hitam.aajp.net</a></div>

    <div class="weui-cells__title" style="margin-top: 30px;">博物馆参观</div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell weui-cell_switch" id="item-2-div-0">
            <div class="weui-cell__bd">是否参观</div>
            <div class="weui-cell__ft">
                <input class="weui-switch" type="checkbox" id="item-2-visited"/>
            </div>
        </div>
    </div>
    <input id="hidden-input-2" type="hidden" name="item[2].bookProxyed" value="0"/>
    <div class="weui-cells__tips">预约方式见官网 <a href="http://www.museum.hit.edu.cn">www.museum.hit.edu.cn</a></div>

    <div class="weui-cells__title" style="margin-top: 30px;">其他需求</div>
    <div class="weui-cells weui-cells_form">
        <!-- <div class="weui-cell weui-cell_switch">
            <div class="weui-cell__bd">对接校友会</div>
            <div class="weui-cell__ft">
                <input class="weui-switch" type="checkbox" id="switch-btn-0" />
            </div>
        </div> -->
        <input type="hidden" name="meetAlumniAssociation" value="0"/>
        <div class="weui-cell weui-cell_switch">
            <div class="weui-cell__bd">接受学校采访</div>
            <div class="weui-cell__ft">
                <input class="weui-switch" type="checkbox" id="switch-btn-1"/>
                <input type="hidden" name="acceptInterview" value="0"/>
            </div>
        </div>
        <div class="weui-cell weui-cell_switch">
            <div class="weui-cell__bd">给在校生开讲座</div>
            <div class="weui-cell__ft">
                <input class="weui-switch" type="checkbox" id="switch-btn-2"/>
                <input type="hidden" name="giveLecture" value="0"/>
            </div>
        </div>
        <div class="weui-cell weui-cell_switch">
            <div class="weui-cell__bd">志愿者帮助拍照</div>
            <div class="weui-cell__ft">
                <input class="weui-switch" type="checkbox" id="switch-btn-3"/>
                <input type="hidden" name="needVolunteer" value="0"/>
            </div>
        </div>
    </div>
    <div class="weui-cells__tips">除寒暑假外可提供志愿者服务</div>
    <div class="weui-btn-area" style="text-align: center;">
        <input class="weui-btn weui-btn_mini weui-btn_primary btn-c" value="提交" type="submit">
    </div>
</form>
</body>

<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script src="http://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<script>
    var item0Chosen = 0;
    var item1Chosen = 0;
    var item2Chosen = 0;
    var item0Chosen_ = 0;
    var item1Chosen_ = 0;
    var item2Chosen_ = 0;
    var switchBtn0Chosen = 0;
    var switchBtn1Chosen = 0;
    var switchBtn2Chosen = 0;
    var switchBtn3Chosen = 0;

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

    $(function(){
        getShowDelayDate(7,"beginDate");
        getShowDelayDate(8,"endDate");
    });

    function getShowDelayDate(delayDays,inputName){
        var curDate=new Date();
        var year=curDate.getFullYear();
        var month=curDate.getMonth()+1;
        var date=curDate.getDate();
        if((date+delayDays)>28){//跨月
            date=(date+delayDays)%28;//显示的日期中的日
            if(month==12){//跨年
                month=1;//显示日期中的月
                year=year+1;//显示日期中的年
            }else{
                month=month+1;//显示日期中的月
            }
        }else{
            date=date+delayDays;//显示日期中的日
        }
        $("input[name='"+inputName+"']").val(year+"-"+((month>9)?month:("0"+month))+"-"+((date>9)?date:("0"+date)));
    }

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
    $("#item-1-visited").change(function () {
        if (item1Chosen == 0) {
            item1Chosen = 1;
            var div = '<div class="weui-cell weui-cell_switch" id="item-1-div-1"><div class="weui-cell__bd">校友会代预约</div><div class="weui-cell__ft"><input class="weui-switch" type="checkbox" id="item-1-bookProxyed"/></div></div>';
            $("#item-1-div-0").after(div);
            $("#item-1-bookProxyed").change(function () {
                if (item1Chosen_ == 0) {
                    item1Chosen_ = 1;
                    var div_ = '<div class="weui-cell" id="item-1-div-2"><div class="weui-cell__hd"><label for="" class="weui-label">参观时间</label></div><div class="weui-cell__bd"><input class="weui-input" type="datetime-local" value="" name="itemastronauticsMuseumVisitedDate" required="required" /></div></div>';
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
    $("#switch-btn-0").change(function () {
        if (switchBtn0Chosen == 0) {
            switchBtn0Chosen = 1;
            $("input[name='meetAluUnion']").val(1);
        } else {
            switchBtn0Chosen = 0;
            $("input[name='meetAluUnion']").val(0);
        }
    });
    $("#switch-btn-1").change(function () {
        if (switchBtn1Chosen == 0) {
            switchBtn1Chosen = 1;
            $("input[name='interviewAccepted']").val(1);
        } else {
            switchBtn1Chosen = 0;
            $("input[name='interviewAccepted']").val(0);
        }
    });
    $("#switch-btn-2").change(function () {
        if (switchBtn2Chosen == 0) {
            switchBtn2Chosen = 1;
            $("input[name='giveLecture']").val(1);
        } else {
            switchBtn2Chosen = 0;
            $("input[name='giveLecture']").val(0);
        }
    });
    $("#switch-btn-3").change(function () {
        if (switchBtn3Chosen == 0) {
            switchBtn3Chosen = 1;
            $("input[name='needVolunteer']").val(1);
        } else {
            switchBtn3Chosen = 0;
            $("input[name='needVolunteer']").val(0);
        }
    });
</script>
</html>

