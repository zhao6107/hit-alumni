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
<div class="weui-msg bd-m-t" style="margin-top: 20px;padding-top: 20px;">
    <div class="weui-msg__icon-area" style="margin-bottom: 20px;"><i class="weui-icon-success weui-icon_msg"></i></div>
    <div class="weui-msg__text-area">
        <h2 class="weui-msg__title">完成捐赠</h2>
        <c:if test="${empty out_trade_no}">
            <p class="weui-msg__desc">哈工大校友会感谢您的捐赠</p>
        </c:if>
        <c:if test="${!empty out_trade_no}">
            <p class="weui-msg__desc">感谢您的捐赠，下方领取您的捐赠证书吧</p>
        </c:if>
    </div>
</div>
<c:if test="${!empty out_trade_no}">
    <img style="width: 100%;height: auto;display: block;"
         src="${applicationScope.globalUrlPrefix}/wechat/cer/${out_trade_no}.jpg">
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
</c:if>
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
