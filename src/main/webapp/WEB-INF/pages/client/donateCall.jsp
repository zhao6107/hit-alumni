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
<div class="container js_container">
    <div class="hd">捐赠倡议书</div>
    <div class="weui-btn-area" style="text-align: right;margin-top: 16px;margin-bottom: 16px;">
        <a href="${applicationScope.globalUrlPrefix}/wechat/donate/list"
           class="weui-btn weui-btn_mini weui-btn_primary btn-c">前去捐助&nbsp;&gt;&gt;</a>
    </div>
    <article class="weui-article" style="background-color:#ffffff;">
        <h1 align="center">汇聚点滴爱心 助力母校辉煌<br>哈工大校友年度捐赠倡议书</h1>
        <section>
            <section>
                <p style="margin-bottom: 15px;">亲爱的校友们：<br>
                    　　母校，是我们共同的牵挂。我们在哈工大学习、生活，度过了最美好的青春岁月。每年，都有几千学子从这里走出校门，走向社会，凭借在母校获得的“规格严格，功夫到家”的专业知识和技能，在各自的工作岗位上兢兢业业，努力耕耘，为社会经济的发展贡献力量。<br>
                    　　建校97年来，哈工大不负重托，为国家和社会培养了学生近三十万之众。哈工大人已经成为国家建设、社会发展的一支重要力量。饮水思源，很多校友深感母校滋养的可贵，在为社会贡献力量、做出自己的成绩后，纷纷回馈母校，或为学校捐款捐物、设立各种奖助学金；或建言献策、与学校合作，支持母校发展建设。或许一个人的力量有限，但当众多哈工大人汇聚在一起，就有如流入汪洋大海的水滴，蒸腾为云，再化作甘霖下降，润泽四方，让孕育他们的河源更加丰沛。<br>
                    　　“让母校的明天更美好”是所有哈工大人的共同愿望。随着时代的进步和网络的发展，回馈母校也变得更加方便。“点点心意点点善。”为此，哈工大校友总会借助网络发起了小额在线捐赠平台，倡议各位校友在母校校庆日、校友活动、班级聚会时，向母校捐赠。各位校友给予母校的每一份回报，不论多少、不论大小，都包含着一片爱心和无尽深情。所有捐赠学校将通过哈工大教育发展基金会，用于支持学生成长成才、促进教育教学创新、推动科学技术进步和学校各项事业发展等。<br>
                    　　亲爱的校友，行动起来吧，汇聚点滴爱心、助力母校辉煌！期待每一位哈工大人的热情参与。</p>
                <p align="right" style="margin-bottom: 4px;">哈尔滨工业大学校友会　</p>
                <p align="right" style="margin-bottom: 4px;">哈工大教育发展基金会　</p>
                <p align="right">2017年5月18日 　　</p>
            </section>
        </section>
    </article>
    <div class="weui-btn-area" style="text-align: center;margin-top: 20px;margin-bottom: 20px;">
        <a href="${applicationScope.globalUrlPrefix}/wechat/donate/list"
           class="weui-btn weui-btn_mini weui-btn_primary btn-c">我要捐助</a>
    </div>
</div>
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

