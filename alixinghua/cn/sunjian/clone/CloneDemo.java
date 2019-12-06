package cn.sunjian.clone;

/**
 * Clone�������ϰ��
 * 		��¡
 * @author sunjian
 *
 */
class Person implements Cloneable{//ʵ��Cloneable�ӿڣ���ʾ���Ա���¡
	private String name;
	public Person(String name){
		this.name = name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	//Ϊ�˴�ӡ����дtoString()����
	public String toString(){
		return "������"+this.name;
	}
	
	//��д���ӿ��е�clone()����
	public Object clone() throws CloneNotSupportedException{
		return super.clone();//����Ŀ�¡�����ɸ������
	}
	
}

public class CloneDemo {

	public static void main(String[] args) throws Exception {

		Person p1 = new Person("����");
		Person p2 = (Person)p1.clone();
		
		p2.setName("sunjian");
		
		System.out.println("ԭʼ����"+p1);
		System.out.println("��¡����"+p2);
	}

}
