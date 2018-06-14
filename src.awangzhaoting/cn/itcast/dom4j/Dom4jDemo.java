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
 * Dom4j������
 * 
 * @author sunjian
 *
 */
public class Dom4jDemo {

	//1���õ�ĳ�����w�Ĺ��c���ݣ���2����������
	@SuppressWarnings("unchecked")
	@Test
	public void test1() throws Exception{
		//�õ�Document����
		SAXReader reader = new SAXReader();
		Document document = reader.read(Constant.XML_FILE_PATH+"book.xml");
		//�õ���Ԫ��
		Element root = document.getRootElement();
		//���εõ��ڶ�����������
		List<Element> es = root.elements();
		Element e = es.get(1);
		Element author = e.element("����");
		//�õ����ݴ�ӡݔ��
		System.out.println(author.getText());
		//���ԽY��
		Assert.assertEquals("����", author.getText());
	}
	public void test11() throws Exception{
		//�õ�Document����
		SAXReader reader = new SAXReader();
		Document document = reader.read(Constant.XML_FILE_PATH+"book.xml");
	
		String xpath = "//��[2]/����";
		Node node = document.selectSingleNode(xpath);
		System.out.println(node.getText());
		
		Assert.assertEquals("����", node.getText());
	}
	
	//2���������е�Ԫ�ؽڵ�
	@Test
	public void test2() throws Exception{
		//�õ�Document����
		SAXReader reader = new SAXReader();
		Document document = reader.read(Constant.XML_FILE_PATH+"book.xml");
		//�õ���Ԫ��
		Element root = document.getRootElement();
		
		//�������е�Ԫ�أ���ӡ��������
		TreeWalk(root);
//		TreeWalk1(root);		
	}
	private void TreeWalk1(Element root) {
		System.out.println(root.getName());
		//�ڵ������
		int count = root.nodeCount();
		for(int i=0;i<count;i++){
			//ȡ�����ϵĽڵ�
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
