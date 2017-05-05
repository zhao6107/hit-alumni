package net.i2it.hit.hit_alumni.util;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLDecoder;
import java.util.Map;

/**
 * 生成捐赠证书(pdf、图片)的工具类-->
 * 有如下方法：
 * ①填写pdf模板中的表单域生成新的pdf文件（itext)
 * ②将pdf转为图片格式（pdfbox）
 * <p>
 * Created by liuming on 2017/4/28.
 */
public class DonateCertificateUtil {

    private static String PDF_FILE_PATH;
    private static String CER_FOLD_PATH;
    private static String IAMGE_FILE_PATH;

    static {
        try {
            PDF_FILE_PATH = URLDecoder.decode(DonateCertificateUtil.class.getClassLoader().getResource("donate-cer.pdf").getPath(), "utf-8");
            CER_FOLD_PATH = URLDecoder.decode(DonateCertificateUtil.class.getClassLoader().getResource("cer/").getPath(), "utf-8");
            IAMGE_FILE_PATH = URLDecoder.decode(DonateCertificateUtil.class.getClassLoader().getResource("donate-cer.jpg").getPath(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通用的 根据pdf模板（填写表单）生成新的pdf文件
     *
     * @param data
     * @param srcFile
     * @param newFile
     */
    public static void createCerPDF(Map<String, String> data, String srcFile, String newFile) {
        try {
            PdfReader reader = new PdfReader(srcFile);//读取pdf模板
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            PdfStamper stamper = new PdfStamper(reader, bos);

            // todo 设置pdf字体以及各式
            AcroFields form = stamper.getAcroFields();
            java.util.Iterator<String> it = form.getFields().keySet().iterator();
            while (it.hasNext()) {
                String name = it.next();
                form.setField(name, data.get(name));
            }
            stamper.setFormFlattening(true);//如果为false那么生成的PDF文件还能编辑，一定要设为true
            stamper.close();

            FileOutputStream out = new FileOutputStream(newFile);//输出流
            out.write(bos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    // 针对本项目的更为简便的调用方法，生成新的pdf文件
    public static void createCerPDF(Map<String, String> data) {
        createCerPDF(data, PDF_FILE_PATH, CER_FOLD_PATH + data.get("out_trade_no") + ".pdf");
    }

    /**
     * 通用的 根据pdf文件转为对应的图片
     *
     * @param pdfFile
     * @param imageFile
     */
    public static void pdf2Image(String pdfFile, String imageFile) {
        try {
            PDDocument document = PDDocument.load(new File(pdfFile));
            PDFRenderer renderer = new PDFRenderer(document);
            BufferedImage bufferedImage = renderer.renderImageWithDPI(0, 96, ImageType.RGB);
            ImageIO.write(bufferedImage, "PNG", new File(imageFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //本项目中直接使用将pdf转为图片
    public static void pdf2Image(String out_trade_no) {
        pdf2Image(CER_FOLD_PATH + out_trade_no + ".pdf", CER_FOLD_PATH + out_trade_no + ".png");
    }

    public static boolean generateCerImage(Map<String, String> map) {
        String out_trade_no = map.get("out_trade_no");
        File imageFile = new File(CER_FOLD_PATH + out_trade_no + ".png");
        if (!imageFile.exists()) {//图片格式的捐赠证书是否已经存在，存在就不需要进行重复生成
            File pdfFile = new File(CER_FOLD_PATH + out_trade_no + ".pdf");
            if (!pdfFile.exists()) {//pdf格式的捐赠证书是否已经存在，存在就可以直接将其转为图片，不需要重复创建
                createCerPDF(map);
            }
            pdf2Image(out_trade_no);
        }

        if (imageFile.exists()) {
            return true;
        }
        return false;
    }

    public static void drawTextInImg(Map<String, String> data) {
        String part = "　　兹接受" + data.get("name") + "校友向哈尔滨工业大学校友会捐赠人民币" + data.get("money") + "元。";
        String line1 = part.substring(0, 23);
        String line2 = part.substring(23);
        try {
            BufferedImage image = ImageIO.read(new File(IAMGE_FILE_PATH));
            Graphics graphics = image.getGraphics();
            graphics.setColor(new Color(141, 12, 7));
            graphics.setFont(new Font("华文中宋", Font.BOLD, 55));
            graphics.drawString(line1, 220, 550);
            graphics.drawString(line2, 220, 640);
            graphics.drawString("　　颁发此证，谨致谢忱。", 220, 730);
            graphics.setFont(new Font("华文中宋", Font.BOLD, 48));
            graphics.drawString("哈尔滨工业大学校友会", 1000, 820);
            graphics.drawString(data.get("date"), 1050, 910);
            graphics.dispose();
            ImageIO.write(image, "jpg", new File(CER_FOLD_PATH + data.get("out_trade_no") + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
