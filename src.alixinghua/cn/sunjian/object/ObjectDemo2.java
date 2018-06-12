package cn.sunjian.object;
/**
 * Object 类练习
 * 
 * 覆写equals方法
 * 
 * @author sunjian
 *
 */
class Person2{
	private String name;
	private int age;
	
	public Person2(String name,int age){
		this.age = age;
		this.name = name;
	}
	//覆写Object类中的equals方法
	public boolean equals(Object obj){
		//判断当前类中的对象与传入的对象是否是一个
		if (this == obj) {
			return true;
		}
		//如果不是一个
		//判断传入的对象是否是当前类的对象,如果不是，返回false；如果是，继续向下判断
		if (!(obj instanceof Person2)) {
			return false;
		}
		
		//如果传入的对象时Person的对象,因为是由object接收的，所有需要向下强制转型
		Person2 per = (Person2)obj;
		
		//判断当前对象的属性和传入的对象的属性是否一样(内容和地址)
		if (per.name.equals(this.name) && per.age == this.age) {
			return true;
			
		}else {
			return false;
		}
	}
	
}

public class ObjectDemo2 {

	public static void main(String[] args) {
		Person2 p1 = new Person2("jack", 31);
		Person2 p2 = new Person2("jack", 31);
		
		System.out.println(p1.equals(p2)?"是同一个人":"不是同一个人");
		System.out.println(p1.equals("hello")?"是同一个人":"不是同一个人");
	}

}
