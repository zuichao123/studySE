package cn.sunjian.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * java反射机制的深入研究：重点复习；
 * 
 * 		调用Person3类中的sayChina()方法：(无参)
 * 		调用Person3类中的sayHello()方法：(有参)
 * 
 * 		调用Person3类中的setter()方法
 * 		调用Person3类中的getter()方法
 * 
 * 		调用Person3类中的属性；
 * 
 * @author jack
 *
 */
public class InvokeMethodDemo {

	public static void main(String[] args) {

		Class<?> c = null;//声明Class类对象
		
		try {
			c = Class.forName("cn.sunjian.reflect.Person3");//实例化Class类对象
		} catch (Exception e) {
			e.printStackTrace();
		}
		Object obj = null;
		try {
			obj = c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * 调用无参方法
		 */
		try {
			Method m1 = c.getMethod("sayChina");//找到sayChina()方法
			m1.invoke(c.newInstance());//调用方法（无参的）
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * 如果现在调用的方法中存在了参数，则必须设置参数的类型及内容；
		 */
		try {
			Method m2 = c.getMethod("sayHello", String.class,int.class);//找到sayHello()方法
			String rv = null;
			
			rv = (String) m2.invoke(c.newInstance(), "sunjian",30);
			System.out.println(rv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * 调用setter()方法
		 */
		setter(obj, "name", "孙健", String.class);//调用setter方法
		setter(obj, "age", 30, int.class);
		
		/*
		 * 调用getter()方法
		 */
		System.out.print("姓名： ");
		getter(obj, "name");
		System.out.print("年龄：");
		getter(obj, "age");
		
		/*
		 * 调用属性：与setter和getter方法无关
		 * 		调用公共属性；getField(String name)
		 * 		调用本类属性；getDeclaredField(String name)
		 * 		设置属性；set(Object obj,String name)
		 * 在访问私有属性的时候，必须让这个属性可见：setAccessible(true)
		 */
		Field nameField = null;
		Field ageField = null;
		
		try {
			nameField = c.getDeclaredField("name");//得到name属性
			ageField = c.getDeclaredField("age");//得到age属性
			
			nameField.setAccessible(true);//设置name属性可见
			ageField.setAccessible(true);//设置age属性可见
			
			nameField.set(obj, "齐天大圣");//设置name属性内容
			ageField.set(obj, 500);//设置age属性内容
			System.out.println("姓名："+nameField.get(obj));
			System.out.println("年龄："+ageField.get(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Object obj:要操作的对象
	 * String att:要操作的属性
	 * Object value：要设置的属性内容
	 * Class<?> type:要设置的属性类型
	 */
	public static void setter(Object obj,String att,Object value,Class<?> type){
		try {			
			Method met = obj.getClass().getMethod("set"+initStr(att),type);//得到setter方法
			met.invoke(obj, value);//设置setter的内容
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getter(Object obj,String att){//传入操作对象和参数
		try {			
			Method met = obj.getClass().getMethod("get"+initStr(att));//得到setter方法
			System.out.println(met.invoke(obj));//调用getter取得内容后输出
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String initStr(String old) {//将单词的首字母大写
		String str = old.substring(0,1).toUpperCase() + old.substring(1);
		return str;
	}

}
