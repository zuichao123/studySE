package cn.sunjian.statics;

/**
 * 联系static关键字的用法
 * 
 * @author sunjian
 *
 */

class Person{
	private String name;
	private int age;
	private static String country = "A城";
	
	public static void setCountry(String c){
		country = c;
	}
	public String getCountry(){
		return country;
	}
	public Person(String name,int age){
		this.age = age;
		this.name = name;
	}
	
	
	public void info(){
		System.out.println(name+age+country);
	}
}

public class TestStatic {
	public static void main(String[] args) {
		Person p1 = new Person("张三", 30);
		Person p2 = new Person("李四", 31);
		
		System.out.println("----------修改前---------");
		p1.info();
		p2.info();
		System.out.println("-------修改后---------");
		Person.setCountry("B城");
		p1.info();
		p2.info();
	}
}
