package cn.sunjian.collection_onetoone;

import java.util.Iterator;

/**
 * �����ࣺ
 * 
 * 		����һ�Զ��ϵ
 * 
 * 		��׼����Ŀ���������
 * 		
 * @author sunjian
 *
 */
public class TestDemo {

	public static void main(String[] args) {

		School sch = new School("ɽ������");//����ѧУ
		
		Student s1 = new Student("sunjian", 30);
		Student s2 = new Student("sunjian2", 32);
		Student s3 = new Student("sunjian3", 33);
		
		sch.getAllStudents().add(s1);//ΪѧУ���ѧ��
		sch.getAllStudents().add(s2);
		sch.getAllStudents().add(s3);
		
		s1.setSchool(sch);//Ϊѧ������ѧУ
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
