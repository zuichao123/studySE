package cn.itcast.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.itcast.domain.Student;
import cn.itcast.util.DocumentUtil;

/**
 * 数据访问对象类
 * 
 * @author jack
 *
 */
public class StudentDao {

	/**
	 * 添加学生信息到XML文件中
	 */
	public boolean createStudent(Student s){
		//目标：在根元素exam中添加Student子元素
		boolean result = false;
		
		try {
			Document document = DocumentUtil.getCocument();
			//创建name、location、grade元素并设置其主体内容
			Element nameE = document.createElement("name");
			nameE.setTextContent(s.getName());
			Element locationE = document.createElement("location");
			locationE.setTextContent(s.getLocation());
			Element greadeE = document.createElement("grade");
			greadeE.setTextContent(s.getGrade()+"");
			//创建Student元素，并设置其属性
			Element studentE = document.createElement("student");
			studentE.setAttribute("idcard", s.getIdcard());
			studentE.setAttribute("examid", s.getExamid());
			
			studentE.appendChild(nameE);
			studentE.appendChild(locationE);
			studentE.appendChild(greadeE);
			//得到exam根元素，把Student挂接上去
			Node node = document.getElementsByTagName("exam").item(0);
			node.appendChild(studentE);
			//写回到XML文件中
			DocumentUtil.writeXml(document);
			
			result = true;
		} catch (Exception e) {
			throw new RuntimeException(e);//异常转义；异常链；
			//System.out.println("StudentDao creudent exception:" + e.getMessage());
		}
		
		return result;
	}
	
	/**
	 * 根据学生姓名删除学生
	 * 如果学生不存在，返回false
	 */
	public boolean deleteStudent(String name){
		
		boolean result = false;
		
		try {
			//得到Document对象
			Document document = DocumentUtil.getCocument();
			//得到所有的name元素
			NodeList nl = document.getElementsByTagName("name");
			//遍历name元素，判断其主体内容是否与参数一致
			for(int i=0;i<nl.getLength();i++){
				//如果一致：找到它爸爸的爸爸，将它的爸爸删除
				Node node = nl.item(i);
				if (node.getTextContent().equals(name)) {
					node.getParentNode().getParentNode().removeChild(node.getParentNode());
					//写回XML文档中
					DocumentUtil.writeXml(document);
					result = true;
					break;
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}
	
	/**
	 * 根据准考证号查询学生信息
	 * 如果学生不存在，返回null
	 */
	public Student findStudent(String examid){
		
		Student s = null;
		
		try {
			//得到Document对象
			Document document = DocumentUtil.getCocument();
			//得到所有的Student元素
			NodeList nl = document.getElementsByTagName("student");
			//遍历student元素，判断它的examid属性的取值是否与参数一致
			for(int i=0;i<nl.getLength();i++){
				Node node = nl.item(i);
//				if (node.getNodeType() == Node.ELEMENT_NODE) {
				if (node instanceof Element) {
					Element e = (Element) node;
					if (e.getAttribute("examid").equals(examid)) {
						//如果匹配：说明找到了学生；创建学生对象
						s = new Student();
						//设置学生对象的各个属性
						s.setExamid(examid);
						s.setIdcard(e.getAttribute("idcard"));
						s.setName(e.getElementsByTagName("name").item(0).getTextContent());
						s.setLocation(e.getElementsByTagName("location").item(0).getTextContent());
						s.setGrade(Float.parseFloat(e.getElementsByTagName("grade").item(0).getTextContent()));
					}
				
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return s;
	}
}
