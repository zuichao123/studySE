package cn.sunjian.collection.manytomany;

import java.util.Iterator;

/**
 * 测试类：
 * 
 * 		java类集的多对多
 * 
 * @author sunjian
 *
 */
public class TestMore {

	public static void main(String[] args) {

		Course c1 = new Course("计算机", 1);//第一门课程
		Course c2 = new Course("英语",3);
		
		Student s1 = new Student("sunjian", 30);
		Student s2 = new Student("sunjian2", 32);
		Student s3 = new Student("sunjian3", 33);
		Student s4 = new Student("sunjian4", 34);
		Student s5 = new Student("sunjian5", 35);
		Student s6 = new Student("sunjian6", 36);
	
		//第一门课程有三个学生参加
		c1.getAllStudents().add(s1);
		c1.getAllStudents().add(s2);
		c1.getAllStudents().add(s3);
		s1.getAllCourses().add(c1);
		s2.getAllCourses().add(c1);
		s3.getAllCourses().add(c1);
		
		//第二门课程有6个学生参加
		c2.getAllStudents().add(s1);
		c2.getAllStudents().add(s2);
		c2.getAllStudents().add(s3);
		c2.getAllStudents().add(s4);
		c2.getAllStudents().add(s5);
		c2.getAllStudents().add(s6);
		s1.getAllCourses().add(c2);
		s2.getAllCourses().add(c2);
		s3.getAllCourses().add(c2);
		s4.getAllCourses().add(c2);
		s5.getAllCourses().add(c2);
		s6.getAllCourses().add(c2);
		
		//输出一门课程的信息，观察一门课程有多少个学生参加
		
		System.out.println(c1);
		Iterator<Student> iterator = c1.getAllStudents().iterator();		
		while(iterator.hasNext()){
			System.out.println("\t|--"+iterator.next());
		}
		System.out.println(c2);
		Iterator<Student> iterator2 = c2.getAllStudents().iterator();
		while(iterator2.hasNext()){
			System.out.println("\t|--"+iterator2.next());
		}
		
		//通过学生找到学生参加的课程
		System.out.println(s3);
		Iterator<Course> iterator3 = s3.getAllCourses().iterator();
		while(iterator3.hasNext()){
			System.out.println("\t|--"+iterator3.next());
		}
		
	}

}
