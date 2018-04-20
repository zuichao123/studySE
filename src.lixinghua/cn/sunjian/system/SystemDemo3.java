package cn.sunjian.system;

/**
 * System����ϰ��
 * 		
 * 		��������
 * 
 * @author jack
 *
 */

class Person{
	private String name;
	private int age;
	
	public Person(String name,int age){
		this.age = age;
		this.name = name;
	}
	
	//��дtoString����
	public String toString(){
		return "name:"+this.name + ", age:"+this.age;
	}
	
	/*
	 * ��дfinalize()����(non-Javadoc)
	 * @see java.lang.Object#finalize()
	 * 
	 * �����ͷſռ�ʱĬ�ϵ��ô˷���
	 * 
	 */
	public void finalize() throws Throwable{
		System.out.println("�����ͷ�-->" + this);
	}
}

public class SystemDemo3 {

	public static void main(String[] args) {

		Person per = new Person("sunjian",30);
		
		per = null;//�Ͽ�����
		
		System.gc();//ǿ���ͷſռ�
				
		
	}

}
