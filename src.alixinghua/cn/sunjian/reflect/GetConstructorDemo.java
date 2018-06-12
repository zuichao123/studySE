package cn.sunjian.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * java反射机制：
 * 
 * 		取得类的结构：
 * 			取得类的全部构造方法；
 * 
 * @author jack
 *
 */
public class GetConstructorDemo {

	public static void main(String[] args) {
	
		Class<?> c = null;//声明Class对象；
		
		try {
			c = Class.forName("cn.sunjian.reflect.Person3");//实例化对象；
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Constructor<?> con[] = c.getConstructors();//取得全部的构造方法
		
		for(int i=0;i<con.length;i++){			
//			System.out.println("构造方法："+con[i]);
			/*
			 * 以上的类中的构造方法，时通过对象直接打印取得的，肯定会调用Constructor类中的toString()方法。
			 */
			
			System.out.println("******************");
			Class<?>[] p = con[i].getParameterTypes();//得到构造方法中的全部参数
			System.out.print("构造方法：");
			int mo = con[i].getModifiers();//取得访问权限
			System.out.print(Modifier.toString(mo)+" ");//取得修饰符
			System.out.print(con[i].getName());//取得构造方法的名字
			System.out.print("(");
			for(int j=0;j<p.length;j++){
				System.out.println(p[j].getName()+"  arg  "+i);
				if (j<p.length-1) {
					//判断此时是否是最后一个参数
					System.out.print(",");
				}
			}
			System.out.println("){}");
		}
		/*
		 * java中的权限是通过数组表示的，如果想要还原成用户可以看得懂的，需要使用Modifier()方法中的toString()方法完成；
		 */
	}

}
