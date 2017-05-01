package net.i2it.hit.hit_alumni.util;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    private static final String TEMPLATE_FILE_PATH = "D:/我的代码/CodeRepo/hit-alumni/src/main/resources/donate-cer.pdf/";
    private static final String CER_FOLD_PATH = "D:/我的代码/CodeRepo/hit-alumni/src/main/resources/cer/";


    // 利用pdf模板生成新的pdf文件
    public static void createCerPDF(Map<String, String> map) {
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {
            reader = new PdfReader(TEMPLATE_FILE_PATH);//读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);

            AcroFields form = stamper.getAcroFields();
            java.util.Iterator<String> it = form.getFields().keySet().iterator();
            while (it.hasNext()) {
                String name = it.next().toString();
                form.setField(name, map.get(name));
            }
            stamper.setFormFlattening(true);//如果为false那么生成的PDF文件还能编辑，一定要设为true
            stamper.close();

            out = new FileOutputStream(CER_FOLD_PATH + map.get("out_trade_no") + ".pdf");//输出流
            out.write(bos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void pdf2Image(String out_trade_no) {
        try {
            PDDocument document = PDDocument.load(new File(CER_FOLD_PATH + out_trade_no + ".pdf"));
            PDFRenderer renderer = new PDFRenderer(document);
            BufferedImage bufferedImage = renderer.renderImage(0, 96, ImageType.RGB);
            ImageIO.write(bufferedImage, "PNG", new File(CER_FOLD_PATH + out_trade_no + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateCerImage(Map<String, String> map) {
        String out_trade_no = map.get("out_trade_no");
        File imageFile = new File(CER_FOLD_PATH + out_trade_no + ".png");
        if (!imageFile.exists()) {//图片格式的捐赠证书是否已经存在，存在就不需要进行重复生成
            File pdfFile = new File(CER_FOLD_PATH + out_trade_no + ".pdf");
            if (!pdfFile.exists()) {//pdf格式的捐赠证书是否已经存在，存在就可以直接将其转为图片，不需要重复创建
                createCerPDF(map);
            }
            pdf2Image(out_trade_no);
        }
    }

}
