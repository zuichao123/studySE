package cn.sunjian.abstracts;

/**
 * 给抽象类实例化对象
 * 
 * 模板设计模式
 * 
 * @author sunjian
 *
 */
abstract class Person2{
	private String name;
	private int age;
	
	public Person2(String name,int age){
		this.age = age;
		this.name = name;
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
	
	public void say(){
		System.out.println(this.getContent());
	}
	
	public abstract String getContent();
	
}

class Student2 extends Person2{
	private float score;
	public Student2(String name,int age,float score){
		super(name, age);
		this.score = score;
	}
	
	public String getContent(){
		return "学生："+super.getName()+"、"+super.getAge()+"、"+this.score;
	}
}
class Worker2 extends Person2{
	private float salaty;
	public Worker2(String name,int age,float salaty){
		super(name,age);
		this.salaty = salaty;
	}
	public String getContent(){
		return "工人："+super.getName()+"、"+super.getAge()+"、"+this.salaty;
	}
}


public class ModuleDemo {

	public static void main(String[] args) {
		Person2 p = new Student2("szb", 11, 100);
		p.say();
		
		Person2 p2 = new Worker2("bzs", 31, 10000);
		p2.say();
	}

}
