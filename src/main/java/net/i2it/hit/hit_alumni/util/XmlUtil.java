package net.i2it.hit.hit_alumni.util;

import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import net.i2it.hit.hit_alumni.entity.bo.UnifiedOrderBO;

public class XmlUtil {

	public static String object2XmlStr(Object obj) {
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller(); // 根据上下文获取marshaller对象

			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8"); // 设置编码字符集
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化XML输出，有分行和缩进

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			marshaller.marshal(obj, baos);

			String xmlObj = new String(baos.toByteArray()); // 生成XML字符串
			System.out.println(xmlObj);
			return xmlObj;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		object2XmlStr(new UnifiedOrderBO());
	}

}
