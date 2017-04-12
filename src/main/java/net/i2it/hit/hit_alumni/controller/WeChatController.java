package net.i2it.hit.hit_alumni.controller;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 处理和微信服务器之间的网络交互操作
 */
@Controller
@RequestMapping("/wechat")
public class WeChatController {

    /**
     * 用于验证微信服务器发来的微信开发接入请求
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @param out
     */
    @RequestMapping(method = RequestMethod.GET, params = {"signature", "timestamp", "nonce", "echostr"})
    public void verify(String signature, String timestamp, String nonce, String echostr, PrintWriter out) {
        // 第一步：对参数token、timestamp、nonce排序
        String[] arr = new String[]{ConfigConsts.TOKEN, timestamp, nonce};
        Arrays.sort(arr);
        //第二步：将排序后的token、timestamp、nonce参数拼接为一个字符串后，进行sha1加密
        StringBuffer tmp = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            tmp.append(arr[i]);
        }
        String result = toSHA1(tmp.toString());
        // 第三步：加密结果与signature比较，相同时返回参数echostr
        if (result != null && result.equals(signature)) {
            out.print(echostr);
        } else {
            System.out.println("收到非微信服务器发来的验证请求，请小心！");
        }
        out.flush();
        out.close();
    }

    /**
     * sha1加密算法
     *
     * @param text
     * @return
     */
    private static String toSHA1(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA");
            digest.update(text.getBytes());
            return Hex.encodeHexString(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

}
