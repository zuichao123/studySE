package cn.sunjian.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * java反射机制：
 * 
 * 		取得类的结构：
 * 			取得类的全部方法；
 * 
 * @author jack
 *
 */
public class GetMethodDemo {

	public static void main(String[] args) {
	
		Class<?> c = null;//声明Class对象；
		
		try {
			c = Class.forName("cn.sunjian.reflect.Person3");//实例化对象；
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
//		Method[] m = c.getDeclaredMethods();//取得本类全部方法
		Method[] m = c.getMethods();//取得所有（包括父类）全部方法
		for(int i=0;i<m.length;i++){
			Class<?> r = m[i].getReturnType();//取得返回值类型
			Class<?> p[] = m[i].getParameterTypes();//取得全部参数的类型
			int x = m[i].getModifiers();//得到修饰符
			System.out.print(Modifier.toString(x)+" ");//输出修饰符(访问权限)
			System.out.print(r+" ");//输出返回值类型
			System.out.print(m[i].getName());
			System.out.print("(");
			for(int j=0;j<p.length;j++){
				System.out.print(p[j].getName()+" "+"arg"+j);
				if (j<p.length) {
					System.out.print(",");
				}
			}
			Class<?> ex[] = m[i].getExceptionTypes();//取出异常
			if (ex.length>0) {
				System.out.print(") throws ");
			}else {				
				System.out.print(")");
			}
			for(int j=0;j<ex.length;j++){
				System.out.print(ex[j].getName());
				if (j<p.length) {
					System.out.print(",");
				}
			}
			
			System.out.println();
		}
		
	}

}
