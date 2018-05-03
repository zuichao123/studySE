package cn.sunjian.io.serializable;

import java.io.Serializable;

/**
 * 对象序列化和反序列化操作练习
 * 
 * @author jack
 *
 */

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;//JDK版本验证
	private String name;
	private int age;
	
	public Person(String name,int age){
		this.age = age;
		this.name = name;
	}
	public String toString(){
		return "姓名："+name+"年龄："+age;
	}

}
