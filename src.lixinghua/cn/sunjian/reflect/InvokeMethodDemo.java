package cn.sunjian.reflect;

import java.lang.reflect.Method;

/**
 * java反射机制的深入研究：
 * 
 * 		调用Person3类中的sayChina()方法：(无参)
 * 		调用Person3类中的sayHello()方法：(有参)
 * 
 * 		调用Person3类中的setter()方法
 * 		调用Person3类中的getter()方法
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
		Object obj = null;
		try {
			obj = c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setter(obj, "name", "孙健", String.class);//调用setter方法
		setter(obj, "age", 30, int.class);
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
	private static String initStr(String old) {//将单词的首字母大写
		String str = old.substring(0,1).toUpperCase() + old.substring(1);
		return str;
	}

}
