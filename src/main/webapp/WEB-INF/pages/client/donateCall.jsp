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
        <a href="${applicationScope.globalUrlPrefix}/wechat/donate/list" class="weui-btn weui-btn_mini weui-btn_primary btn-c">我要捐助</a>
    </div>
</div>
<div style="margin-top: 15px;text-align:right;">
    <span style="color:#999999;font-size: 16px;">分享到：</span>
    <span style="margin-right: 10px;">
            <button id="AppMessage" style="border: none;background:none;"><img style="width: 20px;height: auto;"
                                                                               src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAADSklEQVRYR71XzVEbMRSWdgYttzgVYCogVIDpIK4AuPDkU0wFQAUxJ7xcSCrAVABUkKWCkA7so82MXubbkRx5rZXWjCe6gHel97736Xs/K8UGqyiKr0KII2b+gmNSyh7+MvOz/V3if631Y1uzMrXx/v6+s1gsLoUQp0KITmq/fT9l5kme5xdnZ2fT2JkogKIoroQQ3zZwXPcF5yMium4CEQRgo34SQlRUb2GVSqnjEBtrAO7u7r4YYx6klN0tOF6aYOa3LMv65+fnpW93BQAin8/nv7bt3DkEiDzPD30mVgCMx+NSSnmwzcgDtkoiOnTPlwCs4KD2pvWHmQGwohCpKKWERvY+APiaiCBwUQGwovsdUjszvzLzcDAYVLleX7e3t70sy2DsaAMgU6XUPq6iAlAUxQ8hxEnAwE8iQv4nV8RG09nKtgOAfP3k72TmR601Kl/F0Pv7+8HOzs6rLyBEv7u7W7pnG4KYEtFnacvrQx2mMWZ/MBi8WYZAMfRxQUQjPLPUPzHzjdZ66F0lzqwEE6GvL8fj8UhKiWrnrxciquq8Z3iolBr5DBRFMTTGTADUAtpj5lPXI1L3BvBgAOKqC6jV3VvxnjJzF7XfCRXFjJkRAJiJZclLE4AVBkKRWOcjpdSwqeG4PQ0Ch9kSALjuABVLa70foxBXl+f5VarbJbJMBAFYx0vB1YFYirtENLEOQPWJq3AQNjN/d0FYJoLibLoC2J1KKY/rzcNlhatkNiPQuLpOA9ZhzwG0Z9a0hiIXA1CBMMb061UQZdsHkFI73jdlW1Ma+jb7iARpJoR4Q8oBQD0lUyBCjc6lIardWiGyBmfGmKGU8jLQohs1UgfjilYAZL+xFKciimnEPxuZMWZE1Ek1oxSOoEZqFRTtO1SM/jWjWJqkEOC9HcsnWZZVs4IxBrNCRyl1s1gsQgBmSqnush271LINp43PtnvcSF4f51cHEmftf4xkyH2t9XLaXhtKGyhrG3Fq35J6tzE4lqOzfXDWiwGYoU1Hx3JfvfP5/HlbEzJoz/O81+rDxA/BTspoNG0nnDoDM/tpVk3AodX24xRjGCpmWyBwPInNCo0aiF2ibbM9fA8wc8ddUdXVpETKoeVO/C6YUuVfHQ7z8jZsAMQAAAAASUVORK5CYII="></button>
            <button id="Timeline" style="border: none;background:none;"><img style="width: 20px;height: auto;"
                                                                             src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAACtElEQVRYR8WXzXEaMRTHn3TQHu0OQgfBFQRXEDoIXNBywxUkriDhBOIC7gBXELuCkA6cDpIjOuhl3o60o130tTPMWCcGJL2f3ucfBu+82Dvbh0EASqkpIn4GgBFjbNKDPyHiiXO+XiwWp9KHFQEopVZCiIPW+gcAfMlc/ggAfwHgRgixns/n9Dm6kgC73W6MiHsAGAPASQhxXwBBALS+IuIbIs6Xy+VLjCAKsNlsZpxzMu6vEogWwB00xhDEIQQRBIgYd+dzEBcAdDAGcQFg3f4rE+cURBDAQtz3w9EB2O/3t1rrnzbmuUSOQUQBKCeqqrrzE7MDoJT6RsmTs+z9HoKIAthzD1JKqqZm9QFWAHA7AIC2nqSUR6UUJRmVaMoDv6uqmgQ9YGNPTSa5GGPPsUZjId5cGfoXIWJj3JbxkaA7HvBekAJ4klLOUhvsQ6Z+KHvGyUvtPW0IttvtiTH2MXF51rg76+dSwDhte5VSNq28BVBK4TWM0x0OIGK8MSOlbGyXADwJIVZa64mLWy5PLMCIwhULbSmAM0694VlKSWWaXZQHlKipvCoB8I3TMHosBbBhcGUZBA4B0MT6ZHf3jdPXxQC5iqLcqOuaHtXJAUccMt4AMMaOObGRM04XIeK6rmtqeh0Aqt2pTbjQPGg6HCJ+qOt6HvKr1wNyzax9yJBh5AuNA0GQRAOAVO+4ADHG/PG1QWgWfI/gd3o8Ih6qqno4n88vmQbWua6vCy70QKIjXgyZoRB+8jmqmCChirjpeSI45YZAMMbu+kk8RJKlxmw2HMWSzL06oAuTQiPhiX/GmNUgUeogqKyMMQebZDmlQyXa8QTFnHM+S/WOoj8m5A2C4pyPcpLNQWitZ770ijWGIgDfI4i4QsRxoPReAYDUUKt2slOrrwlLDlx7zyAPXNs43fcf+f/WMBkW9ikAAAAASUVORK5CYII="></button>
            <button id="QQ" style="border: none;background:none;"><img style="width: 20px;height: auto;"
                                                                       src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAACcElEQVRYR72Xy3HbMBBAF9QMeIxcgeUKElcQq4JYFdi6EOQpTgVOKrBvJHSRXIGVCiJXELmCuAT6JvGAzSyH4Ih/UAKNIwnsvv1hFwxOWIvF4gsAfCIRnue9HCOK9Tm0XC7H+/3+hjF2CwCkvLAQ8Q0ANoj4FATBxkS2MUAYhreO4zwAwNhEMCJuXNedzefzuG2/EUCmfGmiuLQnZoxNPc/bNp3tBJBSXgPA8xHK0yMUFtd1L5s80QpAMU+S5J+p21sgfwkhftb9bwWQUq4A4OZY6w/OxZzzizovNAJYtD7lUErNgyAggwqrEeDU2Nd47UkIQeVrDEAxu7fgfi3iRQhx1QfAVvxznZzzs3IetIUALVqvRVWqoRZggPg3hqEJwHb89aX06vt+oYfUAkRRtGaMfbMdAkT87fs+3az5qgBYvHxq+ZVS08NOWQCIouiRMfbdtuUleVshxKX+lgOEYXjlOM6fgZVXbsUcQEpJw8T5RwDQrOD7/pR0pQA0WiHi349QrnUopS6CIHhLAaSUg5Rdm0E6GTWA9WvXwJvprZgCHNT9OwA8Wm5COQsivjLGPmcfZkKItfbAHQA8UM+mqdZxHJqCrC9qRkmS0Hx4XsgBGj52u92YkiLzyBD3QToPZAk/IevzKqgzNYqi7YG7TvXGO+d80msky0hpFK88QPrSIOLKdd0fxgBSSnrVfO2rqGN/rJSalV9MlWYUhuFkqCQEgFgIcdbaDbNpmJIxfXR2LCpbyur8kdqxvzIX1s4DWfypNKl314GQ4jXn/E7HNZuiaP+kFL4UUim16jWWa0uyEs0TcTQaxW1vvS6Xlf//B4wpGDCv88ztAAAAAElFTkSuQmCC"></button>
            <button id="QZnoe" style="border: none;background:none;"><img style="width: 20px;height: auto;"
                                                                          src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAACyElEQVRYR8VXy3HbMBDFQjPkMXIFtiqwO4hSQeQKIl0I8hSlgsgdOCcSusiuIE4FsTqwK4hSgaWjNCNsZjkAB6QB/pwoe9GHAPbt570Fgf1ng7f4l1IuaL8QIv/sY70BrFar4eFw+EVOgyAYzWaz7UkBpGk65ZyvyKlSapYkyd1JAUgpN4yxc3KKiJs4jkcnA5Cm6Zhz/tN2qJT6kCTJY1cQvXogy7IHAPhYcXYvhJj+cwBpml5wzvPmq5pSapQkCZWmtXXOgKbeV4+Hm66U7AOA6PbOA2ArhDhrHT5jrBMAm3o+J10pWQBYLpdXJjJEHBsH9ncAKP6vixIRCzYAgOv7LoqiJzoDpJQkIJ+6pO0vrr0HLakPjLH31YMR8ZkxtgGAHK1SqsRzw3vK3vF4HJr9nPMxIg4BYGLEygF6HQTBpCiBJxNbRMydGwMAasLiP5PiKIrW9jop5ZwxRmwpgFnPC80oNWEDxbyZp0xxzqdUV51RmhEUvctKVH3Fgjadbp+KiN/iOKZomZbo756onUPLSUOqqe5kH9/J304pNTF9kGXZLQB89kS9IwaZzi+V1JdXDYKaM594FcsbiO4Aeh2lnGjsst/UjC7ntLhWiKie+/3+EQAurZO/CCFu6XdDo9GYfg7DcFx3WWlUQosdpUh05FT7CwtclcqNE7INAJpuL0qp6zaTjqblYDA4V0qRDlBZQCl159vbWILD4fDi5V+LB0EQnPUugZSSuEy0eotdCyGomZ1Wm4EGarUCZeuEa0MtACklaf+rGWEOosNzKvn5T4/XQgjvFG0CgJ4w1wAwN9zWjCBqOsEKIbx+vA9cN1+tfnPfO4CWcQJSUtC6G7MXQHUwUbrDMFw0vQFp8VpUyuK9K3oBmKu3PeladZ1eRBkEAJoPl4j4I45j53SsywDdlJ6M7HZxbq/Vcn3le2doVMK+jtvu+wOPmmKIzqJiFAAAAABJRU5ErkJggg=="></button>
        </span>
</div>
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

    $("#AppMessage").click(function() {
        alert(123);
        wx.onMenuShareAppMessage({
            title: '我参与了母校的捐款活动，你有我捐得多吗？→ →',
            desc: '尽一分力，助力母校腾飞！',
            link: '${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg',
            imgUrl: '${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg',
            type: '',
            dataUrl: '',
            success: function () {
                // 用户确认分享后执行的回调函数
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
            }
        });
    });
    $("#Timeline").click(function () {
        wx.onMenuShareTimeline({
            title: '我参与了母校的捐款活动，你有我捐得多吗？→ →',
            link: '${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg',
            imgUrl: '${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg',
            success: function () {
                // 用户确认分享后执行的回调函数
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
            }
        });
    });
    $("#QQ").click(function () {
        wx.onMenuShareQQ({
            title: '我参与了母校的捐款活动，你有我捐得多吗？→ →',
            desc: '尽一分力，助力母校腾飞！',
            link: '${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg',
            imgUrl: '${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg',
            success: function () {
                // 用户确认分享后执行的回调函数
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
            }
        });
    });
    $("#QZnoe").click(function () {
        wx.onMenuShareQZone({
            title: '我参与了母校的捐款活动，你有我捐得多吗？→ →',
            desc: '尽一分力，助力母校腾飞！',
            link: '${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg',
            imgUrl: '${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg',
            success: function () {
                // 用户确认分享后执行的回调函数
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
            }
        });
    });
</script>
</html>

