package cn.itcast.util;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

/**
 * ����XML�Ĺ�����
 * �������е��쳣������Ҳ���Դ���
 * 
 * @author jack
 *
 */
public class DocumentUtil {

	//�õ�Document����
	public static Document getCocument() throws Exception{
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		return builder.parse(Constant.XML_FILE_PATH+"exam.xml");
	}
	//д��XML�ļ�
	public static void writeXml(Document document) throws Exception {
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(document), new StreamResult(Constant.XML_FILE_PATH+"exam.xml"));
	}

	public static void main(String[] args) throws Exception {
		System.out.println(DocumentUtil.getCocument());
	}
}
