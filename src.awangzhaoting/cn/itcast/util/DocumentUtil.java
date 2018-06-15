package cn.itcast.util;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

/**
 * 操作XML的工具类
 * 工具类中的异常可以抛也可以处理
 * 
 * @author jack
 *
 */
public class DocumentUtil {

	//得到Document对象
	public static Document getCocument() throws Exception{
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		return builder.parse(Constant.XML_FILE_PATH+"exam.xml");
	}
	//写入XML文件
	public static void writeXml(Document document) throws Exception {
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(document), new StreamResult(Constant.XML_FILE_PATH+"exam.xml"));
	}

	public static void main(String[] args) throws Exception {
		System.out.println(DocumentUtil.getCocument());
	}
}
