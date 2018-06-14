package cn.itcast.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Assert;
import org.junit.Test;

import cn.itcast.util.Constant;
import net.sf.saxon.pull.TreeWalker;

/**
 * Dom4j練習：
 * 
 * @author sunjian
 *
 */
public class Dom4jDemo {

	//1、得到某個具體的節點內容：第2本書的作者
	@SuppressWarnings("unchecked")
	@Test
	public void test1() throws Exception{
		//得到Document對象
		SAXReader reader = new SAXReader();
		Document document = reader.read(Constant.XML_FILE_PATH+"book.xml");
		//得到根元素
		Element root = document.getRootElement();
		//依次得到第二本書的作者
		List<Element> es = root.elements();
		Element e = es.get(1);
		Element author = e.element("作者");
		//拿到內容打印輸出
		System.out.println(author.getText());
		//斷言結果
		Assert.assertEquals("毕向东", author.getText());
	}
	public void test11() throws Exception{
		//得到Document对象
		SAXReader reader = new SAXReader();
		Document document = reader.read(Constant.XML_FILE_PATH+"book.xml");
	
		String xpath = "//书[2]/作者";
		Node node = document.selectSingleNode(xpath);
		System.out.println(node.getText());
		
		Assert.assertEquals("毕向东", node.getText());
	}
	
	//2、遍历所有的元素节点
	@Test
	public void test2() throws Exception{
		//得到Document对象
		SAXReader reader = new SAXReader();
		Document document = reader.read(Constant.XML_FILE_PATH+"book.xml");
		//得到根元素
		Element root = document.getRootElement();
		
		//遍历所有的元素，打印它的名称
		TreeWalk(root);
//		TreeWalk1(root);		
	}
	private void TreeWalk1(Element root) {
		System.out.println(root.getName());
		//节点的数量
		int count = root.nodeCount();
		for(int i=0;i<count;i++){
			//取索引上的节点
			Node node = root.node(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				TreeWalk1((Element) node);
			}
		}
	}
	@SuppressWarnings("unchecked")
	private void TreeWalk(Element root) {
		System.out.println(root.getName());
		List<Element> es = root.elements();
		for(Element e:es){
			TreeWalk(e);
		}
	}
	
}
