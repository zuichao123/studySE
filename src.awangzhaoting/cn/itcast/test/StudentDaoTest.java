package cn.itcast.test;

import cn.itcast.dao.IStudentDao;
import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;

/**
 * 测试类：
 * 		测试操作xml文件
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
		System.out.println("*****查询人员成功****"+student);
	}

	private static void deleteStudent(IStudentDao dao) {
		dao.deleteStudent("jack");
		System.out.println("*****删除人员成功****");
	}

	private static void createStudent(IStudentDao dao) {
		Student s = new Student();
		s.setExamid("110");
		s.setIdcard("111");
		s.setName("jack");
		s.setLocation("shanxi");
		s.setGrade(100);
		
		dao.createStudent(s);
		System.out.println("*****添加人员成功****");
	}

}
