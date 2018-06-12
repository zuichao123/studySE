package cn.sunjian.reflect;

/**
 * java反射机制：
 * 
 * 		取得类的结构：
 * 			取得类的父类；
 * 
 * @author jack
 *
 */
public class GetSuperClassDemo {

	public static void main(String[] args) {
	
		Class<?> c = null;//声明Class对象；
		
		try {
			c = Class.forName("cn.sunjian.reflect.Person3");//实例化对象；
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Class<?> c1 = c.getSuperclass();//取得父类
		
		System.out.println("父类名称："+c1.getName());
		
	}

}
