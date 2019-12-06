package cn.sunjian.object;
/**
 * Object 类练习
 * 
 * 覆写toString方法
 * 
 * @author sunjian
 *
 */
class Person{
	private String name;
	private int age;
	
	public Person(String name,int age){
		this.age = age;
		this.name = name;
	}
	//覆写Object类中的toString方法
	public String toString(){
		return "姓名："+this.name+","+"年龄："+this.age;
	}
}

public class ObjectDemo {

	public static void main(String[] args) {
		Person p = new Person("jack", 31);
		
		//默认调用toString方法，但是被我复写了，所调用覆写和的toString方法
		System.out.println(p);
	}

}
