package cn.sunjian.io_objectStream_bean;

/**
 * Serializable:���ڸ������л������id�ŵġ�
 * �����ж���Ͷ����Ƿ���ͬһ��
 * 
 * transient:��˲̬�����л���ʱ�򣬲��뱻���л�ʱ������ʹ������ؼ������Σ�
 * 
 */

import java.io.Serializable;

public class Person implements Serializable/*��ǽӿ�*/{
	
	/**
	 * ���Ĭ�ϵ�uid
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
