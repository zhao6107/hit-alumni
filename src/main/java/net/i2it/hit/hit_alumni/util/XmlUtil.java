package net.i2it.hit.hit_alumni.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

public class XmlUtil {

	/**
	 * 将实例对象转为字符串型的xml
	 *
	 * @param obj
	 * @return
	 */
	public static String object2XmlStr(Object obj) {
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());

			Marshaller marshaller = context.createMarshaller(); // 根据上下文获取marshaller对象
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8"); // 设置编码字符集
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化XML输出，有分行和缩进

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			marshaller.marshal(obj, baos);
			String xmlObj = new String(baos.toByteArray(), "UTF-8"); // 生成XML字符串

			return xmlObj;
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object xmlStr2Object(String xmlStr, @SuppressWarnings("rawtypes") Class clazz) {
		Object xmlObject = null;
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			// 进行将Xml转成对象的核心接口
			Unmarshaller unmarshaller = context.createUnmarshaller();
			StringReader reader = new StringReader(xmlStr);
			xmlObject = unmarshaller.unmarshal(reader);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return xmlObject;
	}

}
