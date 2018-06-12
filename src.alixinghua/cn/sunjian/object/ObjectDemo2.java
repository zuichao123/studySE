package cn.sunjian.object;
/**
 * Object ����ϰ
 * 
 * ��дequals����
 * 
 * @author sunjian
 *
 */
class Person2{
	private String name;
	private int age;
	
	public Person2(String name,int age){
		this.age = age;
		this.name = name;
	}
	//��дObject���е�equals����
	public boolean equals(Object obj){
		//�жϵ�ǰ���еĶ����봫��Ķ����Ƿ���һ��
		if (this == obj) {
			return true;
		}
		//�������һ��
		//�жϴ���Ķ����Ƿ��ǵ�ǰ��Ķ���,������ǣ�����false������ǣ����������ж�
		if (!(obj instanceof Person2)) {
			return false;
		}
		
		//�������Ķ���ʱPerson�Ķ���,��Ϊ����object���յģ�������Ҫ����ǿ��ת��
		Person2 per = (Person2)obj;
		
		//�жϵ�ǰ��������Ժʹ���Ķ���������Ƿ�һ��(���ݺ͵�ַ)
		if (per.name.equals(this.name) && per.age == this.age) {
			return true;
			
		}else {
			return false;
		}
	}
	
}

public class ObjectDemo2 {

	public static void main(String[] args) {
		Person2 p1 = new Person2("jack", 31);
		Person2 p2 = new Person2("jack", 31);
		
		System.out.println(p1.equals(p2)?"��ͬһ����":"����ͬһ����");
		System.out.println(p1.equals("hello")?"��ͬһ����":"����ͬһ����");
	}

}
