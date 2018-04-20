package cn.sunjian.system;

/**
 * System类练习：
 * 		
 * 		垃圾回收
 * 
 * @author jack
 *
 */

class Person{
	private String name;
	private int age;
	
	public Person(String name,int age){
		this.age = age;
		this.name = name;
	}
	
	//覆写toString方法
	public String toString(){
		return "name:"+this.name + ", age:"+this.age;
	}
	
	/*
	 * 覆写finalize()方法(non-Javadoc)
	 * @see java.lang.Object#finalize()
	 * 
	 * 对象释放空间时默认调用此方法
	 * 
	 */
	public void finalize() throws Throwable{
		System.out.println("对象被释放-->" + this);
	}
}

public class SystemDemo3 {

	public static void main(String[] args) {

		Person per = new Person("sunjian",30);
		
		per = null;//断开引用
		
		System.gc();//强制释放空间
				
		
	}

}
