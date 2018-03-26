package cn.sunjian.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import cn.sunjian.reflect.demo.bean.Person;

/**
 *
 */

public class ReflectDemo2 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		createNewObject_2();
	}
	
	
	public static void createNewObject_2() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
//		cn.sunjian.reflect.demo.bean.Person p = new cn.sunjian.reflect.demo.bean.Person();
		
		/*
		 * ����ȡָ�����ƶ�Ӧ���е������ֵĶ���ʱ��
		 * ���ö����ʼ����ʹ�ÿղ������캯������ô���أ�
		 * ��Ȼ��ͨ��ָ���Ĺ��캯�����ж���ĳ�ʼ����
		 * ����Ӧ���Ȼ�ȡ���ù��캯����ͨ���ֽ����ļ����󼴿���ɡ�
		 * �÷����ǣ�getConstructor(paramterTypes);
		 *
		 */
		
		String name = "cn.sunjian.reflect.demo.bean.Person";
		//��Ѱ���������ļ��������ؽ��ڴ棬������Class����
		Class clazz = Class.forName(name);
		//��ȡ����ָ���Ĺ��캯������
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		
		//ͨ���ù����������newInstance�������ж���ĳ�ʼ����
		Object obj = constructor.newInstance("С��",39);
		
		
		
	}


	public static void createNewObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		//���ڣ�new��ʱ���ȸ��ݱ�new�����������Ѱ������ֽ����ļ��������ؽ��ڳ������������ֽ����ļ����󣬲����Ŵ������ֽ����ļ���Ӧ��Person����
//		cn.sunjian.reflect.demo.bean.Person p = new cn.sunjian.reflect.demo.bean.Person();
		
		//���ڣ�
		String name = "cn.sunjian.reflect.demo.bean.Person";
		//��Ѱ���������ļ��������ؽ��ڳ���������class����
		Class clazz = Class.forName(name);
		//��β�������Ķ����أ�
		Object obj = clazz.newInstance();
		
	}
	
}
