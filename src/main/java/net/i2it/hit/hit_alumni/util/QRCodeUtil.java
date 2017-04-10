package net.i2it.hit.hit_alumni.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * 矩阵二维码生成和解析工具类
 */
public class QRCodeUtil {

    @SuppressWarnings("unchecked")
	public static void create(String content, int size, String filepath) {
        @SuppressWarnings("rawtypes")
		Map hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 1);

        try {
            BitMatrix matrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, size, size, hints);
            Path file = new File(filepath).toPath();
            MatrixToImageWriter.writeToPath(matrix, "png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
