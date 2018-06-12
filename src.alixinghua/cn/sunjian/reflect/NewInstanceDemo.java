package cn.sunjian.reflect;

/**
 * java������ƣ�
 * 
 * 		Class���ʹ�ã�ͨ���޲ι���ʵ��������
 * 			���Ҫ��ͨ��Class�౾��ʵ����������Ķ��������ʹ��
 * 			newInstance()����ʵ����Class����
 * 			���Ǳ��뱣֤��ʵ���������б������һ���޲ι��췽����
 * 
 * @author jack
 *
 */
class Person{
	private String name;
	private int age;
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return this.age;
	}
	
	public String toString(){
		return "������"+this.name+",���䣺"+this.age;
	}
}


public class NewInstanceDemo {

	public static void main(String[] args) {
		Class<?> c = null;//����Class����
		
		//ʵ����Class����			
		try{
			c = Class.forName("cn.sunjian.reflect.Person");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		Person per = null;//����Person����
		
		//ʵ����Person����
		try {
			per = (Person) c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {	
			e.printStackTrace();
		}
		
		per.setName("sunjian");//��������
		per.setAge(30);//��������
		
		System.out.println(per);
	}

	/*
	 * ��ʹ��ͨ���ؼ���new����Ҳ���Խ���ʵ������������������ã�
	 * ���ǣ���ʹ�����ϲ�����ʱ����һ�����ע�⣬�ڲ������б�������޲ι��췽����
	 * �����޷�ʵ������
	 * �����Ҫ�����вεĹ��죬����밴�����µĲ�����У�
	 * 		1.ͨ��Class���е�getConstructors()ȡ�ñ����е�ȫ�����췽����
	 * 		2.���췽���д���һ�����������ȥ����������˹��췽��������ĸ���������
	 * 		3.֮��ͨ��Constructorʵ��������
	 */
}
