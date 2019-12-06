package cn.sunjian.useradmin.vo;
/**
 * 数据库结构表
 */
import java.util.Date;

public class User {

	private int id;
	private String name;
	private String password;
	private int age;
	private String sex;
	private Date birthday;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + ", sex=" + sex
				+ ", birthday=" + birthday + "]";
	}
	
	
	
}
