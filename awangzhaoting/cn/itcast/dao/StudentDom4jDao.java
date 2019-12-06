package cn.itcast.dao;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import cn.itcast.domain.Student;
import cn.itcast.util.Dom4jUtil;
/**
 * ���ݿ���ʶ���
 * 		ʹ��Xpath��ʽ��ϰ����XML�ļ���
 * 
 * @author sunjian
 *
 */
public class StudentDom4jDao implements IStudentDao {

	/**
	 * ���student��Ϣ
	 * @param s
	 * @return
	 */
	@Override
	public boolean createStudent(Student s) {

//		System.out.println("Dom4j");
		boolean result = false;
		
		try {
			//�õ�Document����
			Document document = Dom4jUtil.getDocument();
			//�õ���Ԫ��
			Element rootE = document.getRootElement();
			//�������<Student>
			Element studentE = rootE.addElement("student")
					.addAttribute("examid", s.getExamid())
					.addAttribute("idcard", s.getIdcard());
			studentE.addElement("name").setText(s.getName());
			studentE.addElement("location").setText(s.getLocation());
			studentE.addElement("grade").setText(s.getGrade()+"");
			//д��XML�ĵ�
			Dom4jUtil.writeXml(document);
			result = true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}

	/**
	 * ɾ��student��Ϣ
	 * @param name
	 * @return
	 */
	@Override
	public boolean deleteStudent(String name) {

		boolean result = false;
		
		try {
			//�õ�Document����
			Document document = Dom4jUtil.getDocument();
			//�õ����е�nameԪ��
			@SuppressWarnings("unchecked")
			List<Node> nodes = document.selectNodes("//name");
			//�������е�name������Ƿ�һ��
			for(Node n:nodes){
				if (n.getText().equals(name)) {
					//���һ�£��ҵ����İְֵİְ֣�ɾ�����İְ�
					n.getParent().getParent().remove(n.getParent());
				}
			}
			//д��XML�ĵ�
			Dom4jUtil.writeXml(document);
			result = true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}

	/**
	 * ����student��Ϣ
	 * @param examid
	 * @return
	 */
	@Override
	public Student findStudent(String examid) {
		
		Student s = null;//����student����
		
		try {
			//�õ�Document����
			Document document = Dom4jUtil.getDocument();
			//�õ��������������student
			Node node = document.selectSingleNode("//student[@examid='"+examid+"']");
			if (node != null) {
				//���õ���student�ڵ�ת��Ԫ��
				Element e = (Element) node;
				//ʵ����student���󣬲�����������
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
