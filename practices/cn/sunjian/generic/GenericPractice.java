package cn.sunjian.generic;

/**
 * 泛型的实例练习：
 * 
 * @author sunjian
 *
 */

/*
 * 需求：
 * 	用户在设计类的时候往往会使用类的关联关系，例如：一个人中可以定义一个信息属性，
 *  但是一个人可能有各种各样的信息（例如：联系方式、基本信息等），所以此信息属性的类型就可以通过泛型进行声明，
 *  之后只要设计相应的信息类即可。
 */

/*
 * 定义接口
 * 	  标识接口：
 * 		此接口中没有任何的方法
 */
interface Info7{//只有此接口的子类才是表示人的信息
	
}

class Contact implements Info7{
	private String address;//联系方式
	private String telphone;//联系方式
	private String zipcode;//邮政编码
	public Contact(String address, String telphone, String zipcode) {
		super();
		this.address = address;
		this.telphone = telphone;
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String toString(){
		return "联系方式："+"\n"+
					"\t|- 联系电话：" + this.telphone + "\n" +
					"\t|- 联系地址：" + this.address + "\n" +
					"\t|- 邮政编码：" + this.zipcode;
	}
	
}


class Introduction implements Info7{
	private String name;
	private String sex;
	private int age;
	public Introduction(String name, String sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString(){
		return "联系方式："+"\n"+
					"\t|- 姓名：" + this.name + "\n" +
					"\t|- 性别：" + this.sex + "\n" +
					"\t|- 年龄：" + this.age;
	}
	
}


class Person<T extends Info7>{
	private T info;
	public Person(T info){
		this.info = info;
	}
	
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public String toString(){//覆写Object类的toString方法
		return this.info.toString();
	}
}

public class GenericPractice {

	public static void main(String[] args) {
		Person<Contact> per = null;//声明person对象
		per = new Person<Contact>(new Contact("山西省","13152874607","100016"));
	
		System.out.println(per);
		
		//-----------------------
		Person<Introduction> per2 = null;//声明Person对象
		per2 = new Person<Introduction>(new Introduction("sunjian", "男", 30));
		
		System.out.println(per2);
		
	}

}
