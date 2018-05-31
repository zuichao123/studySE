package cn.sunjian.reflect;

import java.lang.reflect.Field;

public class ReflectDemo3 {

	public static void main(String[] args) throws Exception {

		getFieldDemo();
	}

	public static void getFieldDemo() throws Exception {
		Class clazz = Class.forName("cn.sunjian.reflect.demo.bean.Person");
		
		Field field = null; //clazz.getField("age");//只能获取公有的
		
		field = clazz.getDeclaredField("age");//只获取本类，但包含私有。
		
		//对私有字段的访问取消权限检查。暴力访问。
		field.setAccessible(true);
		
		Object obj = clazz.newInstance();
		
		field.set(obj, 89);
		
		Object o = field.get(obj);
		
		System.out.println(o);
	}

}
