package cn.itcast.util;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * DOM4j��ִ��XML�ļ��Ĺ����ࣻ
 * 
 * 
 * @author jack
 *
 */
public class Dom4jUtil {

	//�õ�Document����
	public static Document getDocument() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read(Constant.XML_FILE_PATH+"book.xml");
		return document;
	}
	//д��XML�ļ�
	@SuppressWarnings("unused")
	public static void writeXml(Document document) throws Exception{
		OutputStream out = new FileOutputStream(Constant.XML_FILE_PATH+"book.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out, format);
	}
}
