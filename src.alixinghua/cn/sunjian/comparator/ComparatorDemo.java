package cn.sunjian.comparator;

import java.util.*;

/**
 * Compatator�Ƚ����ӿڲ�����ϰ��
 * 	
 * 	
 * @author jack
 *
 */

class Student{
	private String name;
	private int age;
	
	public Student(String name,int age){
		this.age = age;
		this.name = name;
	}
	
	/*
	 * ��дequals����
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj){
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Student)) {
			return false;
		}
		
		Student stu = (Student)obj;
		
		if (stu.name.equals(this.name) && stu.age == this.age) {
			return true;
		}else {
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	/*
	 * ��дtoString����
	 */
	public String toString(){
		return this.name + this.age;
	}
	
}

/*
 * ʵ�ֱȽ���
 */
class StudentComparator implements Comparator<Student>{
	//��ΪObject���б����Ѿ�����equals����
	public int compare(Student s1,Student s2){
		if (s1.equals(s2)) {
			return 0;
		}else if (s1.getAge() < s2.getAge()) {//��������Ƚ�,��ͨ���޸ķ���ֵ����ʵ�����򡢵���
			return -1;
		}else {
			return 1;
		}
	}
}


public class ComparatorDemo {

	public static void main(String[] args) {

		Student stu[] = {
				new Student("÷��", 30),
				new Student("C��", 32),
				new Student("�ޱ�", 34),
				new Student("�����", 26)
		};
		
		//�����������
		Arrays.sort(stu,new StudentComparator());

		for(int i=0;i<stu.length;i++){
			System.out.println(stu[i]);
		}
	}

}
