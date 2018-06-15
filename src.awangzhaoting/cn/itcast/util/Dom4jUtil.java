package cn.itcast.util;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * DOM4j：执行XML文件的工具类；
 * 
 * 
 * @author jack
 *
 */
public class Dom4jUtil {

	//得到Document对象
	public static Document getDocument() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read(Constant.XML_FILE_PATH+"book.xml");
		return document;
	}
	//写入XML文件
	@SuppressWarnings("unused")
	public static void writeXml(Document document) throws Exception{
		OutputStream out = new FileOutputStream(Constant.XML_FILE_PATH+"book.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out, format);
	}
}
