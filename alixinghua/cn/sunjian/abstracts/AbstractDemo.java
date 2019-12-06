package cn.sunjian.abstracts;

/**
 * �����ࡢ������ϰ
 * 
 * @author jack
 *
 */

abstract class Person{
	private String name;
	private int age;
	
	public Person(String name,int age){
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
	
	abstract void printInfo();
}

class Student extends Person{
	private String school;
	
	public Student(String name,int age,String school){
		super(name, age);
		this.school = school;
	}
	
	public void printInfo(){
		System.out.println("������"+super.getName()+"\n"+
						   "���䣺"+super.getAge()+"\n"+
						   "ѧУ��"+this.school);
	}
	
}

public class AbstractDemo {

	public static void main(String[] args) {
		Student stu = new Student("sunjian", 31, "ɽ������ְҵ����ѧԺ");
		stu.printInfo();
	}

}
