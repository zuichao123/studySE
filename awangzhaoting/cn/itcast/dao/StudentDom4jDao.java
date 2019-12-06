package cn.itcast.dao;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import cn.itcast.domain.Student;
import cn.itcast.util.Dom4jUtil;
/**
 * 数据库访问对象：
 * 		使用Xpath方式练习操作XML文件；
 * 
 * @author sunjian
 *
 */
public class StudentDom4jDao implements IStudentDao {

	/**
	 * 添加student信息
	 * @param s
	 * @return
	 */
	@Override
	public boolean createStudent(Student s) {

//		System.out.println("Dom4j");
		boolean result = false;
		
		try {
			//得到Document对象
			Document document = Dom4jUtil.getDocument();
			//得到根元素
			Element rootE = document.getRootElement();
			//添加数据<Student>
			Element studentE = rootE.addElement("student")
					.addAttribute("examid", s.getExamid())
					.addAttribute("idcard", s.getIdcard());
			studentE.addElement("name").setText(s.getName());
			studentE.addElement("location").setText(s.getLocation());
			studentE.addElement("grade").setText(s.getGrade()+"");
			//写回XML文档
			Dom4jUtil.writeXml(document);
			result = true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}

	/**
	 * 删除student信息
	 * @param name
	 * @return
	 */
	@Override
	public boolean deleteStudent(String name) {

		boolean result = false;
		
		try {
			//得到Document对象
			Document document = Dom4jUtil.getDocument();
			//得到所有的name元素
			@SuppressWarnings("unchecked")
			List<Node> nodes = document.selectNodes("//name");
			//遍历所有的name与参数是否一致
			for(Node n:nodes){
				if (n.getText().equals(name)) {
					//如果一致，找到它的爸爸的爸爸，删除它的爸爸
					n.getParent().getParent().remove(n.getParent());
				}
			}
			//写回XML文档
			Dom4jUtil.writeXml(document);
			result = true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}

	/**
	 * 查找student信息
	 * @param examid
	 * @return
	 */
	@Override
	public Student findStudent(String examid) {
		
		Student s = null;//定义student对象
		
		try {
			//得到Document对象
			Document document = Dom4jUtil.getDocument();
			//得到包含传入参数的student
			Node node = document.selectSingleNode("//student[@examid='"+examid+"']");
			if (node != null) {
				//将得到的student节点转成元素
				Element e = (Element) node;
				//实例化student对象，并设置其属性
				s = new Student();
				s.setExamid(examid);
				s.setIdcard(e.valueOf("@idcard"));
				s.setName(e.elementText("name"));
				s.setLocation(e.elementText("location"));
				s.setGrade(Float.parseFloat(e.elementText("grade")));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return s;
	}

}
