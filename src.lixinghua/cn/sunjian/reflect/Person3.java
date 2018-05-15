package cn.sunjian.reflect;
/**
 * java反射机制：
 * 
 * 		取得类的结构；
 * 
 * @author sunjian
 *
 */
interface China{
	public static final String  NATIONAL = "China";//定义全局常量
	public static final String AUTHOR = "孙健";
	
	public void sayChina();//无参的，没有返回值的方法
	public String sayHello(String name,int age);//定义有两个参数的方法
}


public class Person3 implements China {

	private String name;
	private int age;
	
	public Person3(){}//无参构造
	public Person3(String name){
		this.name = name;
	}
	public Person3(String name,int age){
		this(name);
		this.age = age;
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
	
	public void sayChina(){//覆写方法
		System.out.println("作者："+AUTHOR+",国籍"+NATIONAL);
	}
	public String sayHello(String name,int age){
		return name+"，你好！我今年："+age+"岁了！";
	}
}
