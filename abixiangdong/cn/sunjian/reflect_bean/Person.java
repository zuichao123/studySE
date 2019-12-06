package cn.sunjian.reflect_bean;

public class Person {
	
	private int age;
	private String name;
	public Person(String name,int age) {
		super();
		this.age = age;
		this.name = name;
		
		System.out.println("Person param run..."+this.age+this.name);
	}
	
	public Person(){
		super();
		System.out.println("person run...");
	}

	public void show(){
		System.out.println(name+"...show run..."+age);
	}
	
	@SuppressWarnings("unused")
	private void method(){
		System.out.println("method run...");
	}
	
	public void paramMethod(String str,int num){
		System.out.println("paramMethod run..."+str+":"+num);
	} 
	
	public static void Method(){
		System.out.println("static method run....");
	}
	
}
