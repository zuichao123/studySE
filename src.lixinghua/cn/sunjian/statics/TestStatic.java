package cn.sunjian.statics;

/**
 * ��ϵstatic�ؼ��ֵ��÷�
 * 
 * @author sunjian
 *
 */

class Person{
	private String name;
	private int age;
	private static String country = "A��";
	
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
		Person p1 = new Person("����", 30);
		Person p2 = new Person("����", 31);
		
		System.out.println("----------�޸�ǰ---------");
		p1.info();
		p2.info();
		System.out.println("-------�޸ĺ�---------");
		Person.setCountry("B��");
		p1.info();
		p2.info();
	}
}
