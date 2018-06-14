package cn.itcast.util;

import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;

/**
 * �����ࣺ
 * 		���Բ���xml�ļ�
 * 
 * @author jack
 *
 */
public class StudentDaoTest {

	public static void main(String[] args) {

		StudentDao dao = new StudentDao();
		
		createStudent(dao);
		selectStudent(dao);
		deleteStudent(dao);
	}

	private static void selectStudent(StudentDao dao) {
		Student student = dao.findStudent("110");
		System.out.println("*****��ѯ��Ա�ɹ�****"+student);
	}

	private static void deleteStudent(StudentDao dao) {
		dao.deleteStudent("jack");
		System.out.println("*****ɾ����Ա�ɹ�****");
	}

	private static void createStudent(StudentDao dao) {
		Student s = new Student();
		s.setExamid("110");
		s.setIdcard("111");
		s.setName("jack");
		s.setLocation("shanxi");
		s.setGrade(100);
		
		dao.createStudent(s);
		System.out.println("*****�����Ա�ɹ�****");
	}

}
