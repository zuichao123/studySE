package cn.sunjian.io_objectStream_bean;

/**
 * Serializable:用于给被序列化的类加id号的、
 * 用于判断类和对象是否是同一个
 * 
 * transient:非瞬态（序列化的时候，不想被序列化时，可以使用这个关键字修饰）
 * 
 */

import java.io.Serializable;

public class Person implements Serializable/*标记接口*/{
	
	/**
	 * 添加默认的uid
	 */
	private static final long serialVersionUID = 9527L;
	private transient String name;
	private static int age;
	
	
	public Person(String name, int age) {
		super();
		this.name = name;
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
	

}
