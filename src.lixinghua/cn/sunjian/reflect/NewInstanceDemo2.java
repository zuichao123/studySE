package cn.sunjian.reflect;

import java.lang.reflect.Constructor;

/**
 * java������ƣ�
 * 
 * 		Class���ʹ�ã�ͨ���вι���ʵ��������
 * 
 * @author jack
 *
 */
class Person2{
	private String name;
	private int age;
	
	public Person2(String name,int age){
		this.setAge(age);
		this.setName(name);
	}
	
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


public class NewInstanceDemo2 {

	public static void main(String[] args) {
		Class<?> c = null;//����Class����
		
		//ʵ����Class����			
		try{
			c = Class.forName("cn.sunjian.reflect.Person2");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		Person2 per = null;//����Person2����
		
		Constructor<?> cons[] = null;//����������ƶ��󣬷��ص���һ�����й��췽��������
		cons = c.getConstructors();//ʵ����������ƶ��󣬵õ��������еĹ��췽��
		
		//ʵ����Person2����
		try {
			per = (Person2) cons[0].newInstance("sunjian",30);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
