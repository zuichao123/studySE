package cn.sunjian.reflect;

/**
 * java反射机制：
 * 
 * 		取得类的结构：
 * 			取得类实现的全部接口；
 * 
 * @author jack
 *
 */
public class GetInstanceDemo {

	public static void main(String[] args) {
	
		Class<?> c = null;//声明Class对象；
		
		try {
			c = Class.forName("cn.sunjian.reflect.Person3");//实例化对象；
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Class<?> c1[] = c.getInterfaces();//以数组形式返回实现的全部接口；
		for(int i=0;i<c1.length;i++){
			System.out.println("实现的接口名称："+c1[i].getName());//输出
		}
		
	}

}
