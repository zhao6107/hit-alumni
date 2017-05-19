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
        <a href="${applicationScope.globalUrlPrefix}/wechat/donate/list" class="weui-btn weui-btn_mini weui-btn_primary btn-c">前去捐助&nbsp;&gt;&gt;</a>
    </div>
    <article class="weui-article" style="background-color:#ffffff;">
        <h1 align="center">汇聚点滴爱心 助力母校辉煌<br>哈工大校友年度捐赠倡议书</h1>
        <section>
            <section>
                <p style="margin-bottom: 4px;">亲爱的校友们：<br>
                    　　母校，是我们共同的牵挂。我们在哈工大学习、生活，度过了最美好的青春岁月。每年，都有几千学子从这里走出校门，走向社会，凭借在母校获得的“规格严格，功夫到家”的专业和技能，在各行各业兢兢业业，努力耕耘，为社会经济的发展贡献力量。<br>
                    　　如果说母校是一条河，哈工大在祖国大地已经汩汩流淌了97年，培养了学生逾三十万之众，哈工大人已经成为支持国家建设、社会发展的一支重要力量。饮水思源，很多校友深感母校滋养的可贵，在为社会贡献力量、做出自己的成绩后，纷纷回馈母校，或为学校捐款捐物、设立各种奖助学金；或为学校发展建言献策、搭建平台。或许一个人的力量有限，但当很多哈工大人汇聚在一起，就有如流入汪洋大海的水滴，蒸腾为云，再化作甘霖下降，润泽四方，让孕育他们的河源更加丰沛。<br>
                    　　“让母校的明天更美好”是所有哈工大人的共同愿望。随着时代的进步和网络的发展，回馈母校也变得更加方便。如创业校友联合会（“丁香会”）在校友中率先发起了为母校师弟师妹发个百元红包、助力家庭经济困难的学子完成学业的在线捐赠活动，并得到广大校友的大力支持和积极响应。校友的凝聚力和捐赠参与度也直接反映大学的魅力和人气，以及校友们对母校的认同。<br>
                    　　“点点心意点点善。”为此，教育发展基金会借助网络发起了小额在线捐赠平台。各位校友给予母校的每一份回报，不论多少、不论大小，都包含着一片爱心和无尽深情。所有捐赠将用于支持学生成才、促进教学进步、推动科学创新和学校发展等。哈工大教育发展基金会会将确保基金运行完全符合章程的公益目的和财务规则，确保公开透明地报告项目执行和财务情况。<br>
                    　　亲爱的校友，行动起来吧，汇聚点滴爱心、助力母校辉煌！期待每一位哈工大人的热情参与。</p>
                <p align="right" style="margin-bottom: 4px;">哈尔滨工业大学校友会　</p>
                <p align="right">2017年5月　　　　</p>
            </section>
        </section>
    </article>
    <div class="weui-btn-area" style="text-align: center;margin-top: 20px;margin-bottom: 20px;">
        <a href="${applicationScope.globalUrlPrefix}/wechat/donate/list" class="weui-btn weui-btn_mini weui-btn_primary btn-c">我要捐助</a>
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

