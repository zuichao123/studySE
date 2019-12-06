package cn.itcast.reflect;

import java.util.Date;

/**
 * 用于反射内省练习的类；
 * 
 * @author sunjian
 *
 */
public class Person {

	private String name;
	private int age;
	private Date birthday;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
	}
	
}
