package cn.sunjian.reflect;
/**
 * java������ƣ�
 * 
 * 		ȡ����Ľṹ��
 * 
 * @author sunjian
 *
 */
interface China{
	public static final String  NATIONAL = "China";//����ȫ�ֳ���
	public static final String AUTHOR = "�｡";
	
	public void sayChina();//�޲εģ�û�з���ֵ�ķ���
	public String sayHello(String name,int age);//���������������ķ���
}


public class Person3 implements China {

	private String name;
	private int age;
	
	public Person3(){}//�޲ι���
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
	
	public void sayChina(){//��д����
		System.out.println("���ߣ�"+AUTHOR+",����"+NATIONAL);
	}
	public String sayHello(String name,int age){
		return name+"����ã��ҽ��꣺"+age+"���ˣ�";
	}
}
