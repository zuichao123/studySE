package cn.sunjian.generic;

/**
 * ���͵�ʵ����ϰ��
 * 
 * @author sunjian
 *
 */

/*
 * ����
 * 	�û���������ʱ��������ʹ����Ĺ�����ϵ�����磺һ�����п��Զ���һ����Ϣ���ԣ�
 *  ����һ���˿����и��ָ�������Ϣ�����磺��ϵ��ʽ��������Ϣ�ȣ������Դ���Ϣ���Ե����;Ϳ���ͨ�����ͽ���������
 *  ֮��ֻҪ�����Ӧ����Ϣ�༴�ɡ�
 */

/*
 * ����ӿ�
 * 	  ��ʶ�ӿڣ�
 * 		�˽ӿ���û���κεķ���
 */
interface Info7{//ֻ�д˽ӿڵ�������Ǳ�ʾ�˵���Ϣ
	
}

class Contact implements Info7{
	private String address;//��ϵ��ʽ
	private String telphone;//��ϵ��ʽ
	private String zipcode;//��������
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
		return "��ϵ��ʽ��"+"\n"+
					"\t|- ��ϵ�绰��" + this.telphone + "\n" +
					"\t|- ��ϵ��ַ��" + this.address + "\n" +
					"\t|- �������룺" + this.zipcode;
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
		return "��ϵ��ʽ��"+"\n"+
					"\t|- ������" + this.name + "\n" +
					"\t|- �Ա�" + this.sex + "\n" +
					"\t|- ���䣺" + this.age;
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
	public String toString(){//��дObject���toString����
		return this.info.toString();
	}
}

public class GenericPractice {

	public static void main(String[] args) {
		Person<Contact> per = null;//����person����
		per = new Person<Contact>(new Contact("ɽ��ʡ","13152874607","100016"));
	
		System.out.println(per);
		
		//-----------------------
		Person<Introduction> per2 = null;//����Person����
		per2 = new Person<Introduction>(new Introduction("sunjian", "��", 30));
		
		System.out.println(per2);
		
	}

}
