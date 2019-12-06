package cn.itcast.test;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.itcast.dao.IStudentDao;
import cn.itcast.dao.StudentDom4jDao;
import cn.itcast.domain.Student;

public class StudentDom4jDaoTest {
	
	private static IStudentDao sDao;
	
	@BeforeClass
	public static void init(){
		sDao = new StudentDom4jDao();
	}
	@AfterClass
	public static void destory(){
		sDao = null;
	}
	@Test
	public void testCreateStudent() {
		Student s = new Student();
		s.setExamid("438");
		s.setIdcard("251");
		s.setName("张白痴");
		s.setLocation("日本");
		s.setGrade(100);
		boolean b = sDao.createStudent(s);
		Assert.assertTrue(b);
	}

	@Test
	public void testFindStudent() {
		Student s = sDao.findStudent("438");
		Assert.assertNotNull(s);
	}
	
	@Test
	public void testDeleteStudent() {
		boolean b = sDao.deleteStudent("张白痴");
		Assert.assertTrue(b);
	}

}
