package cn.itcast.jaxp;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cn.itcast.util.Constant;


/**
 * xml-Dom������
 * 
 * 		����Jaxp����Dom��ʽ������
 * 
 * @author sunjian
 *
 */
public class JaxpDomDemo {
	
	public static void main(String[] args) throws Exception {
		
		//��������ڴ�DOM����Document����
		Document document = null;
		
		//�õ���������DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//�õ�������DocumentBuilder
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			try {
				//����ָ����XML�ĵ����õ������ڴ�DOM����Document����
				document = builder.parse(Constant.XML_FILE_PATH+"book.xml");
			} catch (SAXException e) {				
				e.printStackTrace();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {			
			e.printStackTrace();
		}
		
		test1(document);
		test2(document);
		test3(document);
		test4(document);
		test5(document);
		test6(document);
		test7(document);
		test8(document);
	}

	//1���õ�ĳ������Ľڵ����ݣ���ӡ�ڶ����������
	private static void test1(Document document) {
		
		//���ݱ�ǩ�����ƻ�ȡ���е�����Ԫ��
		NodeList nl = document.getElementsByTagName("����");
		//��������ȡ�õ�2�����������Ԫ��
		Node node = nl.item(1);
		//��ӡ��Ԫ�ص��ı�
		String text = node.getTextContent();
		System.out.println(text);
	}
	
	//2����������Ԫ�ؽڵ㣺��ӡԪ�ص�����
	public static void test2(Node node){
		
		//�жϵ�ǰ�ڵ��ǲ���һ��Ԫ�ؽڵ�
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			//����ǣ���ӡ��������
			System.out.println(node.getNodeName());
		}
		//������ǣ��ҵ����ĺ�����
		NodeList nl = node.getChildNodes();
		int len = nl.getLength();
		for(int i=0;i<len;i++){
			//���������ǣ��ݹ�
			Node n = nl.item(i);
			test2(n);
		}
	}
	
	//3���޸�ĳ��Ԫ�ؽڵ���������ݣ��ѵ�һ������ۼ۸�Ϊ30.00Ԫ
	public static void test3(Document document){
		
		System.out.println("�ѵ�һ������ۼ۸�Ϊ30.00Ԫ:");
		
		//�ҵ���һ������ۼ�
		NodeList nl = document.getElementsByTagName("�ۼ�");
		Node node = nl.item(0);
		//��������������
		node.setTextContent("30.00Ԫ");
		//���ڴ���Document��д��XML�ļ���
		TransformerFactory factory = TransformerFactory.newInstance();
		try {
			Transformer ts = factory.newTransformer();
			try {
				ts.transform(new DOMSource(document), new StreamResult(Constant.XML_FILE_PATH+"book.xml"));
			} catch (TransformerException e) {				
				e.printStackTrace();
			}
		} catch (TransformerConfigurationException e) {		
			e.printStackTrace();
		}
		
	}
	
	//4����ָ��Ԫ�ؽڵ���������Ԫ�ؽڵ㣺��һ������������Ԫ��<�ڲ���>19.00Ԫ
	public static void test4(Document document){
		
		System.out.println("��һ������������Ԫ��<�ڲ���>19.00Ԫ:");
		
		//����һ���µ�Ԫ�ز���������������
		Element element = document.createElement("�ڲ���");
		element.setTextContent("19.00Ԫ");
		//�ҵ���һ����Ԫ��
		Node firstBookNode = document.getElementsByTagName("��").item(0);
		//���½ڵ�ҽӵ���һ������
		firstBookNode.appendChild(element);
		//���ڴ���Document��д��XML�ļ���
		TransformerFactory factory = TransformerFactory.newInstance();
		try {
			Transformer ts = factory.newTransformer();
			try {
				ts.transform(new DOMSource(document), new StreamResult(Constant.XML_FILE_PATH+"book.xml"));
			} catch (TransformerException e) {				
				e.printStackTrace();
			}
		} catch (TransformerConfigurationException e) {		
			e.printStackTrace();
		}
	}
	
	//5����ָ��Ԫ�ؽڵ�������ͬ��Ԫ�ؽڵ㣺�ڵ�һ������ۼ�ǰ������<������>9.00Ԫ
	public static void test5(Document document){
		
		System.out.println("�ڵ�һ������ۼ�ǰ������<������>9.00Ԫ:");
		
		//����һ���µ�Ԫ�ز��������е���������
		Element element = document.createElement("������");
		element.setTextContent("9.00Ԫ");
		//�ҵ���һ������ۼ�
		Node firstBookPrice = document.getElementsByTagName("�ۼ�").item(0);
		//���ۼ۵�ǰ������½���Ԫ�أ�������Ԫ��һ��Ҫʹ�ø�Ԫ������
		firstBookPrice.getParentNode().insertBefore(element, firstBookPrice);
		//���ڴ���Document��д��XML�ļ���
		TransformerFactory factory = TransformerFactory.newInstance();
		try {
			Transformer ts = factory.newTransformer();
			try {
				ts.transform(new DOMSource(document), new StreamResult(Constant.XML_FILE_PATH+"book.xml"));
			} catch (TransformerException e) {				
				e.printStackTrace();
			}
		} catch (TransformerConfigurationException e) {		
			e.printStackTrace();
		}
	}
	
	//6��ɾ��ָ��Ԫ�ؽڵ㣺ɾ���ڲ���
	public static void test6(Document document){
		
		System.out.println("ɾ���ڲ���:");
		
		//�ҵ��ڲ��۽ڵ㣬�ðְ�ɾ��
		Node node = document.getElementsByTagName("�ڲ���").item(0);
		node.getParentNode().removeChild(node);
		//���ڴ���Document��д��XML�ļ���
		TransformerFactory factory = TransformerFactory.newInstance();
		try {
			Transformer ts = factory.newTransformer();
			try {
				ts.transform(new DOMSource(document), new StreamResult(Constant.XML_FILE_PATH+"book.xml"));
			} catch (TransformerException e) {				
				e.printStackTrace();
			}
		} catch (TransformerConfigurationException e) {		
			e.printStackTrace();
		}
	}
	
	//7������XML�ļ����ԣ���ӡ��һ��������Գ�����
	public static void test7(Document document){
		
		System.out.println("��ӡ��һ���������: ");
		
		//�õ���һ����
		Node node = document.getElementsByTagName("��").item(0);
		//��ӡָ�����Ե�ȡֵ
		Element element = (Element) node;
		System.out.println(element.getAttribute("������"));
	}
	
	//8�����һ�����������Ը��ڶ�����
	public static void test8(Document document){
		
		System.out.println("���һ�����������Ը��ڶ�����:");
		
		//�õ��ڶ�����
		Node node = document.getElementsByTagName("��").item(1);
		//��ӳ���������
		Element element = (Element) node;
		element.setAttribute("������1", "ɽ������1");
		//���ڴ���Document��д��XML�ļ���
		TransformerFactory factory = TransformerFactory.newInstance();
		try {
			Transformer ts = factory.newTransformer();
			try {
				ts.transform(new DOMSource(document), new StreamResult(Constant.XML_FILE_PATH+"book.xml"));
			} catch (TransformerException e) {				
				e.printStackTrace();
			}
		} catch (TransformerConfigurationException e) {		
			e.printStackTrace();
		}
	}
}














