package net.i2it.hit.hit_alumni.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 生成捐赠证书的工具类-->
 * 有如下方法：
 * ①读取word模板并修改内容
 * ②将word转为pdf
 * ③将pdf转为图片格式
 * <p>
 * Created by liuming on 2017/4/28.
 */
public class DonateCertificateUtil {

    private static String templatePath;

    static {
        // 得到 工程名/WEB-INF/classes/donate-cer.pdf 路径
        templatePath = DonateCertificateUtil.class.getResource("/").getPath()
                + "/donate-cer.pdf";
    }


    // 利用模板生成pdf
    public static void fillTemplate() {
        // 模板路径
        String templatePath = "C:\\Users\\liuming\\Desktop\\hit-alumni\\捐助证书\\donate-cer - 副本.pdf";
        // 生成的新文件路径
        String newPDFPath = "C:\\Users\\liuming\\Desktop\\hit-alumni\\捐助证书\\ceshi.pdf";
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {
            out = new FileOutputStream(newPDFPath);// 输出流
            reader = new PdfReader(templatePath);// 读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();

            String[] str = {"123456789", "TOP__ONE", "男", "1991-01-01", "130222111133338888", "河北省保定市"};
            int i = 0;
            java.util.Iterator<String> it = form.getFields().keySet().iterator();
            while (it.hasNext()) {
                String name = it.next().toString();
                System.out.println(name);
                form.setField(name, str[i++]);
            }
            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true
            stamper.close();

            Document doc = new Document();
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage);
            doc.close();

        } catch (IOException e) {
            System.out.println(1);
        } catch (DocumentException e) {
            System.out.println(2);
        }

    }

    public static void main(String[] args) {
//        fillTemplate();
    }

}
