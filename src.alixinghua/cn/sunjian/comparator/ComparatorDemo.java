package cn.sunjian.comparator;

import java.util.*;

/**
 * Compatator比较器接口操作练习：
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
	 * 覆写equals方法
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
	 * 覆写toString方法
	 */
	public String toString(){
		return this.name + this.age;
	}
	
}

/*
 * 实现比较器
 */
class StudentComparator implements Comparator<Student>{
	//因为Object类中本身已经有了equals方法
	public int compare(Student s1,Student s2){
		if (s1.equals(s2)) {
			return 0;
		}else if (s1.getAge() < s2.getAge()) {//按照年龄比较,（通过修改返回值，可实现正序、倒序）
			return -1;
		}else {
			return 1;
		}
	}
}


public class ComparatorDemo {

	public static void main(String[] args) {

		Student stu[] = {
				new Student("梅西", 30),
				new Student("C罗", 32),
				new Student("罗本", 34),
				new Student("内马尔", 26)
		};
		
		//进行排序操作
		Arrays.sort(stu,new StudentComparator());

		for(int i=0;i<stu.length;i++){
			System.out.println(stu[i]);
		}
	}

}
