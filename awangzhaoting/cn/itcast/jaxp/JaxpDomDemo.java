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
 * xml-Dom解析：
 * 
 * 		利用Jaxp进行Dom方式解析；
 * 
 * @author sunjian
 *
 */
public class JaxpDomDemo {
	
	public static void main(String[] args) throws Exception {
		
		//定义代表内存DOM树的Document对象
		Document document = null;
		
		//得到解析工厂DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//得到解析器DocumentBuilder
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			try {
				//解析指定的XML文档，得到代表内存DOM树的Document对象
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

	//1、得到某个具体的节点内容：打印第二本书的作者
	private static void test1(Document document) {
		
		//根据标签的名称获取所有的作者元素
		NodeList nl = document.getElementsByTagName("作者");
		//按照索引取得第2个本书的作者元素
		Node node = nl.item(1);
		//打印该元素的文本
		String text = node.getTextContent();
		System.out.println(text);
	}
	
	//2、遍历所有元素节点：打印元素的名称
	public static void test2(Node node){
		
		//判断当前节点是不是一个元素节点
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			//如果是：打印它的名称
			System.out.println(node.getNodeName());
		}
		//如果不是：找到它的孩子们
		NodeList nl = node.getChildNodes();
		int len = nl.getLength();
		for(int i=0;i<len;i++){
			//遍历孩子们：递归
			Node n = nl.item(i);
			test2(n);
		}
	}
	
	//3、修改某个元素节点的主体内容：把第一本书的售价改为30.00元
	public static void test3(Document document){
		
		System.out.println("把第一本书的售价改为30.00元:");
		
		//找到第一本书的售价
		NodeList nl = document.getElementsByTagName("售价");
		Node node = nl.item(0);
		//设置其主体内容
		node.setTextContent("30.00元");
		//把内存中Document树写回XML文件中
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
	
	//4、向指定元素节点中增加子元素节点：第一本书中增加子元素<内部价>19.00元
	public static void test4(Document document){
		
		System.out.println("第一本书中增加子元素<内部价>19.00元:");
		
		//创建一个新的元素并设置其主体内容
		Element element = document.createElement("内部价");
		element.setTextContent("19.00元");
		//找到第一本书元素
		Node firstBookNode = document.getElementsByTagName("书").item(0);
		//把新节点挂接到第一本书上
		firstBookNode.appendChild(element);
		//把内存中Document树写回XML文件中
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
	
	//5、向指定元素节点上增加同级元素节点：在第一本书的售价前面增加<批发价>9.00元
	public static void test5(Document document){
		
		System.out.println("在第一本书的售价前面增加<批发价>9.00元:");
		
		//创建一个新的元素并设置其中的主体内容
		Element element = document.createElement("批发价");
		element.setTextContent("9.00元");
		//找到第一步书的售价
		Node firstBookPrice = document.getElementsByTagName("售价").item(0);
		//在售价的前面加入新建的元素：增加子元素一定要使用父元素来做
		firstBookPrice.getParentNode().insertBefore(element, firstBookPrice);
		//把内存中Document树写回XML文件中
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
	
	//6、删除指定元素节点：删除内部价
	public static void test6(Document document){
		
		System.out.println("删除内部价:");
		
		//找到内部价节点，用爸爸删除
		Node node = document.getElementsByTagName("内部价").item(0);
		node.getParentNode().removeChild(node);
		//把内存中Document树写回XML文件中
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
	
	//7、操作XML文件属性：打印第一本书的属性出版社
	public static void test7(Document document){
		
		System.out.println("打印第一本书的属性: ");
		
		//得到第一本书
		Node node = document.getElementsByTagName("书").item(0);
		//打印指定属性的取值
		Element element = (Element) node;
		System.out.println(element.getAttribute("出版社"));
	}
	
	//8、添加一个出版社属性给第二本书
	public static void test8(Document document){
		
		System.out.println("添加一个出版社属性给第二本书:");
		
		//得到第二本书
		Node node = document.getElementsByTagName("书").item(1);
		//添加出版社属性
		Element element = (Element) node;
		element.setAttribute("出版社1", "山西传智1");
		//把内存中Document树写回XML文件中
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














