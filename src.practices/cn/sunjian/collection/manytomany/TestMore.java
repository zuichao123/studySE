package cn.sunjian.collection.manytomany;

import java.util.Iterator;

/**
 * �����ࣺ
 * 
 * 		java�༯�Ķ�Զ�
 * 
 * @author sunjian
 *
 */
public class TestMore {

	public static void main(String[] args) {

		Course c1 = new Course("�����", 1);//��һ�ſγ�
		Course c2 = new Course("Ӣ��",3);
		
		Student s1 = new Student("sunjian", 30);
		Student s2 = new Student("sunjian2", 32);
		Student s3 = new Student("sunjian3", 33);
		Student s4 = new Student("sunjian4", 34);
		Student s5 = new Student("sunjian5", 35);
		Student s6 = new Student("sunjian6", 36);
	
		//��һ�ſγ�������ѧ���μ�
		c1.getAllStudents().add(s1);
		c1.getAllStudents().add(s2);
		c1.getAllStudents().add(s3);
		s1.getAllCourses().add(c1);
		s2.getAllCourses().add(c1);
		s3.getAllCourses().add(c1);
		
		//�ڶ��ſγ���6��ѧ���μ�
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
		
		//���һ�ſγ̵���Ϣ���۲�һ�ſγ��ж��ٸ�ѧ���μ�
		
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
		
		//ͨ��ѧ���ҵ�ѧ���μӵĿγ�
		System.out.println(s3);
		Iterator<Course> iterator3 = s3.getAllCourses().iterator();
		while(iterator3.hasNext()){
			System.out.println("\t|--"+iterator3.next());
		}
		
	}

}
