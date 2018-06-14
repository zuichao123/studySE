package cn.itcast.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.itcast.domain.Student;
import cn.itcast.util.DocumentUtil;

/**
 * ���ݷ��ʶ�����
 * 
 * @author jack
 *
 */
public class StudentDao {

	/**
	 * ���ѧ����Ϣ��XML�ļ���
	 */
	public boolean createStudent(Student s){
		//Ŀ�꣺�ڸ�Ԫ��exam�����Student��Ԫ��
		boolean result = false;
		
		try {
			Document document = DocumentUtil.getCocument();
			//����name��location��gradeԪ�ز���������������
			Element nameE = document.createElement("name");
			nameE.setTextContent(s.getName());
			Element locationE = document.createElement("location");
			locationE.setTextContent(s.getLocation());
			Element greadeE = document.createElement("grade");
			greadeE.setTextContent(s.getGrade()+"");
			//����StudentԪ�أ�������������
			Element studentE = document.createElement("student");
			studentE.setAttribute("idcard", s.getIdcard());
			studentE.setAttribute("examid", s.getExamid());
			
			studentE.appendChild(nameE);
			studentE.appendChild(locationE);
			studentE.appendChild(greadeE);
			//�õ�exam��Ԫ�أ���Student�ҽ���ȥ
			Node node = document.getElementsByTagName("exam").item(0);
			node.appendChild(studentE);
			//д�ص�XML�ļ���
			DocumentUtil.writeXml(document);
			
			result = true;
		} catch (Exception e) {
			throw new RuntimeException(e);//�쳣ת�壻�쳣����
			//System.out.println("StudentDao creudent exception:" + e.getMessage());
		}
		
		return result;
	}
	
	/**
	 * ����ѧ������ɾ��ѧ��
	 * ���ѧ�������ڣ�����false
	 */
	public boolean deleteStudent(String name){
		
		boolean result = false;
		
		try {
			//�õ�Document����
			Document document = DocumentUtil.getCocument();
			//�õ����е�nameԪ��
			NodeList nl = document.getElementsByTagName("name");
			//����nameԪ�أ��ж������������Ƿ������һ��
			for(int i=0;i<nl.getLength();i++){
				//���һ�£��ҵ����ְֵİְ֣������İְ�ɾ��
				Node node = nl.item(i);
				if (node.getTextContent().equals(name)) {
					node.getParentNode().getParentNode().removeChild(node.getParentNode());
					//д��XML�ĵ���
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
	 * ����׼��֤�Ų�ѯѧ����Ϣ
	 * ���ѧ�������ڣ�����null
	 */
	public Student findStudent(String examid){
		
		Student s = null;
		
		try {
			//�õ�Document����
			Document document = DocumentUtil.getCocument();
			//�õ����е�StudentԪ��
			NodeList nl = document.getElementsByTagName("student");
			//����studentԪ�أ��ж�����examid���Ե�ȡֵ�Ƿ������һ��
			for(int i=0;i<nl.getLength();i++){
				Node node = nl.item(i);
//				if (node.getNodeType() == Node.ELEMENT_NODE) {
				if (node instanceof Element) {
					Element e = (Element) node;
					if (e.getAttribute("examid").equals(examid)) {
						//���ƥ�䣺˵���ҵ���ѧ��������ѧ������
						s = new Student();
						//����ѧ������ĸ�������
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
