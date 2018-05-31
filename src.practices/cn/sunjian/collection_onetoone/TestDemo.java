package cn.sunjian.collection_onetoone;

import java.util.Iterator;

/**
 * 测试类：
 * 
 * 		测试一对多关系
 * 
 * 		标准程序的开发基础。
 * 		
 * @author sunjian
 *
 */
public class TestDemo {

	public static void main(String[] args) {

		School sch = new School("山西机电");//定义学校
		
		Student s1 = new Student("sunjian", 30);
		Student s2 = new Student("sunjian2", 32);
		Student s3 = new Student("sunjian3", 33);
		
		sch.getAllStudents().add(s1);//为学校添加学生
		sch.getAllStudents().add(s2);
		sch.getAllStudents().add(s3);
		
		s1.setSchool(sch);//为学生设置学校
		s2.setSchool(sch);
		s3.setSchool(sch);
		
		Iterator<Student> iterator = sch.getAllStudents().iterator();
		
		System.out.println(sch);
		
		while(iterator.hasNext()){
			System.out.println("\t|"+iterator.next());
//			System.out.println("\t|"+iterator.next().getSchool().getName());
//			System.out.println("\t|"+iterator.next().getName());
//			System.out.println("\t|"+iterator.next().getAge());
			
		}
	}

}
