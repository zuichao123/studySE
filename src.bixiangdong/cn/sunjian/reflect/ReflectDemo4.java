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
		
		method.invoke(obj, "小强",30);
	}

	public static void getMethod_2() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = Class.forName("cn.sunjian.reflect.bean.Person");
		
		Method method = clazz.getMethod("show", null);//获取空参数一般方法。
		
//		Object obj = clazz.newInstance();
		Constructor<?> constructor = clazz.getConstructor(String.class,int.class);
		Object obj = constructor.newInstance("小明",39);
		
		method.invoke(obj, null);
	}

	/*
	 * 获取指定Class中的公共函数。
	 */
	public static void getMethod() throws ClassNotFoundException {
		Class<?> clazz = Class.forName("cn.sunjian.reflect.demo.bean.Person");
		
		Method[] methods = clazz.getMethods();//获取的都是公有的方法。
		methods = clazz.getDeclaredMethods();//获取苯类中的所有方法，包含私有。
		for(Method method : methods){
			
			System.out.println(method);
		}
	}

}
