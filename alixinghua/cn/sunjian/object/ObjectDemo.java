package cn.sunjian.object;
/**
 * Object ����ϰ
 * 
 * ��дtoString����
 * 
 * @author sunjian
 *
 */
class Person{
	private String name;
	private int age;
	
	public Person(String name,int age){
		this.age = age;
		this.name = name;
	}
	//��дObject���е�toString����
	public String toString(){
		return "������"+this.name+","+"���䣺"+this.age;
	}
}

public class ObjectDemo {

	public static void main(String[] args) {
		Person p = new Person("jack", 31);
		
		//Ĭ�ϵ���toString���������Ǳ��Ҹ�д�ˣ������ø�д�͵�toString����
		System.out.println(p);
	}

}
