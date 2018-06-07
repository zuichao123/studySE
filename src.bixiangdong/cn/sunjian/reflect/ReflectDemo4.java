package cn.sunjian.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo4 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		getMethod_3();
	}

	public static void getMethod_3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		Class<?> clazz = Class.forName("cn.sunjian.reflect.bean.Person");
		
		Method method = clazz.getMethod("paramMethod", String.class,int.class);
		
		Object obj = clazz.newInstance();
		
		method.invoke(obj, "Сǿ",30);
	}

	public static void getMethod_2() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = Class.forName("cn.sunjian.reflect.bean.Person");
		
		Method method = clazz.getMethod("show", null);//��ȡ�ղ���һ�㷽����
		
//		Object obj = clazz.newInstance();
		Constructor<?> constructor = clazz.getConstructor(String.class,int.class);
		Object obj = constructor.newInstance("С��",39);
		
		method.invoke(obj, null);
	}

	/*
	 * ��ȡָ��Class�еĹ���������
	 */
	public static void getMethod() throws ClassNotFoundException {
		Class<?> clazz = Class.forName("cn.sunjian.reflect.demo.bean.Person");
		
		Method[] methods = clazz.getMethods();//��ȡ�Ķ��ǹ��еķ�����
		methods = clazz.getDeclaredMethods();//��ȡ�����е����з���������˽�С�
		for(Method method : methods){
			
			System.out.println(method);
		}
	}

}
