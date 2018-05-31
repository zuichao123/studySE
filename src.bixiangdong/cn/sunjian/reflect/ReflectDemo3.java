package cn.sunjian.reflect;

import java.lang.reflect.Field;

public class ReflectDemo3 {

	public static void main(String[] args) throws Exception {

		getFieldDemo();
	}

	public static void getFieldDemo() throws Exception {
		Class clazz = Class.forName("cn.sunjian.reflect.demo.bean.Person");
		
		Field field = null; //clazz.getField("age");//ֻ�ܻ�ȡ���е�
		
		field = clazz.getDeclaredField("age");//ֻ��ȡ���࣬������˽�С�
		
		//��˽���ֶεķ���ȡ��Ȩ�޼�顣�������ʡ�
		field.setAccessible(true);
		
		Object obj = clazz.newInstance();
		
		field.set(obj, 89);
		
		Object o = field.get(obj);
		
		System.out.println(o);
	}

}
