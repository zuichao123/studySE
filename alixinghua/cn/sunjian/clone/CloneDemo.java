package cn.sunjian.clone;

/**
 * Clone类操作练习：
 * 		克隆
 * @author sunjian
 *
 */
class Person implements Cloneable{//实现Cloneable接口，表示可以被克隆
	private String name;
	public Person(String name){
		this.name = name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	//为了打印对象覆写toString()方法
	public String toString(){
		return "姓名："+this.name;
	}
	
	//覆写父接口中的clone()方法
	public Object clone() throws CloneNotSupportedException{
		return super.clone();//具体的克隆操作由父类完成
	}
	
}

public class CloneDemo {

	public static void main(String[] args) throws Exception {

		Person p1 = new Person("张三");
		Person p2 = (Person)p1.clone();
		
		p2.setName("sunjian");
		
		System.out.println("原始对象："+p1);
		System.out.println("克隆对象："+p2);
	}

}
