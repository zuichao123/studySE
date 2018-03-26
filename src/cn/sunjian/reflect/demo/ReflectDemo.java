package cn.sunjian.reflect.demo;

import cn.sunjian.reflect.demo.bean.Person;

/**
 * JAVA���������������״̬�У���������һ���࣬���ܹ�֪���������������Ժͷ�����
 * ��������һ�����󣬶��ܹ�������������һ�����������ԣ�
 * ���ֶ�̬��ȡ����Ϣ�Լ���̬���ö���ķ����Ĺ��ܳ�Ϊjava���Եķ�����ơ�
 * 
 * ��̬��ȡ���е���Ϣ������java���䡣
 * �������Ϊ����Ľ��ʡ�
 *
 *Ҫ����ֽ����ļ����н��ʣ�����Ҫ���ֽ����ļ�����
 *��λ�ȡ�ֽ����ļ������أ�
 */

public class ReflectDemo {

	public static void main(String[] args) throws ClassNotFoundException {

		getClassObject_3();
	}
	
	
	
	/*
	 * ��������
	 * 3��ֻҪͨ������������ַ������ƾͿ��Ի�ȡ���࣬��Ϊ��չ��
	 * ������Class���еķ�����ɡ�
	 * �÷�������forName()��
	 * ���ַ�ʽֻҪ�����Ƽ��ɣ���Ϊ���㣬��չ�Ը�ǿ��
	 */
	public static void getClassObject_3() throws ClassNotFoundException{
		String className = "cn.sunjian.reflect.demo.bean.Person";
		
		Class clazz = Class.forName(className);
		
		System.out.println(clazz);
	}
	
	
	
	/*
	 * ��ʽ����
	 * 2���κ��������Ͷ��߱�һ����̬������.class����ȡ���Ӧ��Class����
	 * ��Լ򵥣����ǻ���Ҫ��ȷ�õ����еľ�̬��Ա��
	 * ���ǲ�����չ��
	 * 
	 */
	public static void getClassObject_2(){
		Class clazz = Person.class;
		
		Class  clazz1 = Person.class;
		
		System.out.println(clazz==clazz1);
	}
	
	

	/*
	 * ��ȡ�ֽ������ķ�ʽ��
	 * 1��Object���е�getClass()������
	 * ��Ҫ�����ַ�ʽ������Ҫ��ȷ������࣬����������
	 * �鷳��
	 */
	public static void getClassObject_1(){
		Person p = new Person();
		Class clazz = p.getClass();
		
		Person p1 = new Person();
		Class clazz1 = p1.getClass();
		
		System.out.println(clazz==clazz1);
	}
	
}
