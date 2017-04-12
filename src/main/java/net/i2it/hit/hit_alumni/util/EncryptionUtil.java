package net.i2it.hit.hit_alumni.util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 关于一些加密算法的工具类
 */
public class EncryptionUtil {

    public static final String SHA1 = "SHA";
    public static final String MD5 = "MD5";

    /**
     * 通用的加密过程
     *
     * @param msg
     * @param encryptionType 在该类中定义了支持的加密算法类型，见类中静态常量
     * @return
     */
    public static String encrypt(String msg, String encryptionType) {
        try {
            MessageDigest digest = MessageDigest.getInstance(encryptionType);
            digest.update(msg.getBytes());
            return Hex.encodeHexString(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

}
