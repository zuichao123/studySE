package cn.sunjian.reflect;

/**
 * java反射机制：
 * 
 * 		认识class：
 * 			练习实例化Class类对象的方法有三种：
				1、通过forName()方法；
				2、类.class
				3、对象.getClass()方法
 * 
 * @author jack
 *
 */
class X{
	
}

public class GetClassDemo {

	public static void main(String[] args) {
		
		Class<?> c1 = null;//指定泛型
		Class<?> c2 = null;
		Class<?> c3 = null;
		
		try {
			//以下操作形式是在开发中最常用的一种形式
			c1 = Class.forName("cn.sunjian.reflect.X");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		c2 = new X().getClass();//通过Object类中的方法实例化
	
		c3 = X.class;//通过类.Class实例化
		
		System.out.println("类名称："+c1.getName());//得到类的名称
		System.out.println("类名称："+c2.getName());//得到类的名称
		System.out.println("类名称："+c3.getName());//得到类的名称
		
		//**********************************
		X x = new X();
		System.out.println(x.getClass().getName());//得到对象所在的类
	}

}
