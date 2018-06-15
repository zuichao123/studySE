package cn.itcast.test;

import cn.itcast.dao.IStudentDao;
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

		IStudentDao dao = new StudentDao();
		
		createStudent(dao);
		selectStudent(dao);
		deleteStudent(dao);
	}

	private static void selectStudent(IStudentDao dao) {
		Student student = dao.findStudent("110");
		System.out.println("*****��ѯ��Ա�ɹ�****"+student);
	}

	private static void deleteStudent(IStudentDao dao) {
		dao.deleteStudent("jack");
		System.out.println("*****ɾ����Ա�ɹ�****");
	}

	private static void createStudent(IStudentDao dao) {
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
