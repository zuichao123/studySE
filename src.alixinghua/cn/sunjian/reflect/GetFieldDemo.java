package cn.sunjian.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * java反射机制：
 * 
 * 		取得类的结构：
 * 			取得类的全部属性；
 * 				本类属性；
 * 				公共属性；
 * 
 * @author jack
 *
 */
public class GetFieldDemo {

	public static void main(String[] args) {
	
		Class<?> c = null;//声明Class对象；
		
		try {
			c = Class.forName("cn.sunjian.reflect.Person3");//实例化对象；
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		{
			//公共属性
			Field[] f = c.getFields();//取得公共的属性
			for(int i=0;i<f.length;i++){
				Class<?> r = f[i].getType();//得到属性类型
				
				int mo = f[i].getModifiers();//得到修饰符的数字
				
				String priv = Modifier.toString(mo);//还原修饰符
				
				System.out.print("公共属性：");
				System.out.print(priv+" ");
				
				System.out.print(r.getName()+" ");//得到属性类型
				System.out.print(f[i].getName());//输出属性名称
				
				System.out.println(" ;");
				
			}
		}
		
		{
			//本类属性
			Field[] f = c.getDeclaredFields();//取得本类的属性
			for(int i=0;i<f.length;i++){
				Class<?> r = f[i].getType();//得到属性类型
				
				int mo = f[i].getModifiers();//得到修饰符的数字
				
				String priv = Modifier.toString(mo);//还原修饰符
				
				System.out.print("本类属性：");
				System.out.print(priv+" ");
				
				System.out.print(r.getName()+" ");//得到属性类型
				System.out.print(f[i].getName());//输出属性名称
				
				System.out.println(" ;");
				
			}
		}
		
	}

}
