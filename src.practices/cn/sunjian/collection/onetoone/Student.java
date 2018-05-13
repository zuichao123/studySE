package cn.sunjian.collection.onetoone;

/**
 * java类集：实例练习
 * 
 * 		一对多关系
 * 
 * 	实例要求：
 * 		使用类集可以表示出以下关系：一个学校可以包含多个学生，一个学生属于一个学校；
 * 		这就是一个典型的一对多关系，此时就可以通过类集进行关系的表示。
 * 
 * 	思路：
 * 		一个学校有多个学生，那么学生的个数属于未知的，那么这样一来肯定无法使用普通的对象数组表示，
 * 		所以，必须通过类集表示。
 * 
 * @author sunjian
 *
 */
public class Student {

	private String name;
	private int age;
	private School school;//一个学生属于一个学校
	
	public Student(String name,int age){
		this.age = age;
		this.name = name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return this.age;
	}
	
	public void setSchool(School school){
		this.school = school;
	}
	public School getSchool(){
		return this.school;
	}
	
	public String toString(){
		return "学生姓名："+ this.name + "，学生年龄：" + this.age;
	}
}
