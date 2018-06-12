package cn.sunjian.reflect;

import java.lang.reflect.Constructor;

/**
 * java反射机制：
 * 
 * 		Class类的使用：通过有参构造实例化对象
 * 
 * @author jack
 *
 */
class Person2{
	private String name;
	private int age;
	
	public Person2(String name,int age){
		this.setAge(age);
		this.setName(name);
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
	
	public String toString(){
		return "姓名："+this.name+",年龄："+this.age;
	}
}


public class NewInstanceDemo2 {

	public static void main(String[] args) {
		Class<?> c = null;//声明Class对象
		
		//实例化Class对象			
		try{
			c = Class.forName("cn.sunjian.reflect.Person2");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		Person2 per = null;//声明Person2对象
		
		Constructor<?> cons[] = null;//声明反射机制对象，返回的是一个所有构造方法的数组
		cons = c.getConstructors();//实例化反射机制对象，得到类中所有的构造方法
		
		//实例化Person2对象
		try {
			per = (Person2) cons[0].newInstance("sunjian",30);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(per);
	}

	/*
	 * 即使不通过关键字new对象也可以进行实例化操作，反射的作用；
	 * 但是，在使用以上操作的时候有一点必须注意，在操作类中必须存在无参构造方法。
	 * 否则无法实例化。
	 * 如果想要调用有参的构造，则必须按照以下的步骤进行：
	 * 		1.通过Class类中的getConstructors()取得本类中的全部构造方法；
	 * 		2.向构造方法中传递一个对象数组进去，里面包含了构造方法中所需的各个参数；
	 * 		3.之后通过Constructor实例化对象；
	 */
}
